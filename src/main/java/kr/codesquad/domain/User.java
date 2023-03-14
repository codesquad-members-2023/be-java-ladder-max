package kr.codesquad.domain;

public class User {
    private final String user;
    public User(String userName) {
        this.user = userName;
    }

    @Override
    public String toString() {
        return user;
    }

    public int findNamesBlank() {
        return 6 - user.length();
    }
}
