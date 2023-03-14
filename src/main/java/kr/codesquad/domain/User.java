package kr.codesquad.domain;

public class User {
    private final int Blank_Number = 6;
    private final String user;
    public User(String userName) {
        this.user = userName;
    }

    @Override
    public String toString() {
        return user;
    }

    public int findNamesBlank() {
        return Blank_Number - user.length();
    }
}
