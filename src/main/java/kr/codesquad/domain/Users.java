package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final int MIN_USER_NAMES_COUNT = 2;

    private final List<User> users;

    public Users(String inputUserNames) {
        String[] userNames = inputUserNames.split(",");
        validateMinUserNamesCount(userNames);
        this.users = generate(userNames);
    }

    private void validateMinUserNamesCount(String[] userNames) {
        if (userNames.length < MIN_USER_NAMES_COUNT) {
            throw new IllegalArgumentException("참여할 사람의 수는 최소 2명입니다.");
        }
    }

    private List<User> generate(String[] userNames) {
        return Arrays.stream(userNames)
            .map(User::new)
            .collect(Collectors.toUnmodifiableList());
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
