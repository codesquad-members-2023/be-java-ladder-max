package kr.codesquad.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private static final int MIN_USER_NAMES_COUNT = 2;

    private final Set<User> users;

    public Users(String inputUserNames) {
        String[] userNames = inputUserNames.split(",");
        validateMinUserNamesCount(userNames);
        this.users = generate(userNames);
        validateDuplicationName(userNames);
    }

    private void validateMinUserNamesCount(String[] userNames) {
        if (userNames.length < MIN_USER_NAMES_COUNT) {
            throw new IllegalArgumentException("참여할 사람의 수는 최소 2명입니다.");
        }
    }

    private void validateDuplicationName(String[] userNames) {
        if (this.users.size() != userNames.length) {
            throw new IllegalArgumentException("참여자 이름 중에 중복된 이름이 있습니다.");
        }
    }

    private Set<User> generate(String[] userNames) {
        return Arrays.stream(userNames)
            .map(User::new)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public int count() {
        return this.users.size();
    }

    @Override
    public String toString() {
        return this.users.stream()
            .map(User::toString)
            .collect(Collectors.joining());
    }
}
