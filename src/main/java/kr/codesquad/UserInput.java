package kr.codesquad;

public class UserInput {
    private final String names;
    private final int height;

    public UserInput(String names, int height) {
        this.names = names;
        this.height = height;
    }

    public String getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
