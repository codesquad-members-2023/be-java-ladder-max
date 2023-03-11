package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesquad.exception.user.UsersDuplicationUserNameException;
import kr.codesquad.exception.user.UsersMinUserCountException;

public class Users {

    public static final int MIN_USER_NAMES_COUNT = 2;

    private final List<User> users;

    public Users(String inputUserNames) {
        String[] userNames = inputUserNames.split(",");
        validateMinUserCount(userNames);
        validateDuplicationName(userNames);
        this.users = generate(userNames);
    }

    private void validateMinUserCount(String[] userNames) {
        if (getFilterNotBlankStream(userNames).count() < MIN_USER_NAMES_COUNT) {
            throw new UsersMinUserCountException();
        }
    }

    private void validateDuplicationName(String[] userNames) {
        long distinctCount = getFilterNotBlankStream(userNames).distinct()
            .count();

        if (getFilterNotBlankStream(userNames).count() != distinctCount) {
            throw new UsersDuplicationUserNameException();
        }
    }

    private Stream<String> getFilterNotBlankStream(String[] userNames) {
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
            .orElseThrow(() -> new NoSuchElementException("참여한 사람 중에 해당 이름은 없습니다."));
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
