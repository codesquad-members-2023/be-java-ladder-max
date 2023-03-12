package kr.codesquad.domain;

public class Player {
    private final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return String.format("%"+MAX_NAME_LENGTH+"s"
                , String.format("%-" + (((MAX_NAME_LENGTH - name.length()) / 2) + name.length()) + "s", name));
    }
}
