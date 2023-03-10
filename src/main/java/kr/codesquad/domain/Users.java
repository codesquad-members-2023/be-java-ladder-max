package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {

    private static final int MIN_USER_NAMES_COUNT = 2;

    private final List<User> users;

    public Users(String inputUserNames) {
        String[] userNames = inputUserNames.split(",");
        validateMinUserNamesCount(userNames);
        validateDuplicationName(userNames);
        this.users = generate(userNames);
    }

    private void validateMinUserNamesCount(String[] userNames) {
        if (getNotBlankStream(userNames).count() < MIN_USER_NAMES_COUNT) {
            throw new IllegalArgumentException("참여할 사람의 수는 최소 2명입니다.");
        }
    }

    private void validateDuplicationName(String[] userNames) {
        long distinctCount = getNotBlankStream(userNames).distinct()
            .count();

        if (getNotBlankStream(userNames).count() != distinctCount) {
            throw new IllegalArgumentException("참여자 이름 중에 중복된 이름이 있습니다.");
        }
    }

    private Stream<String> getNotBlankStream(String[] userNames) {
        return Arrays.stream(userNames)
            .map(userName -> userName.replace(" ", ""))
            .filter(userName -> !userName.isBlank());
    }

    private List<User> generate(String[] userNames) {
        return Arrays.stream(userNames)
            .map(User::new)
            .collect(Collectors.toList());
    }

    public User findByIndex(int index) {
        return this.users.get(index);
    }

    public User findByName(String name) {
        return this.users.stream()
            .filter(user -> user.equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("참여한 사람 중에 해당 이름은 없습니다."));
    }

    public int count() {
        return this.users.size();
    }

    @Override
    public String toString() {
        return this.users.stream()
            .map(User::printFormat)
            .collect(Collectors.joining());
    }
}
