package kr.codesquad.domain;

public class Player {
    private final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    private void validatePlayerName(String name) {
        if(name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 이름은 1글자 이상, 5글자 이하로 입력해 주세요.(※ " + name + ")");
        }
    }

    public String getName() {
        return String.format("%"+MAX_NAME_LENGTH+"s"
                , String.format("%-" + (((MAX_NAME_LENGTH - name.length()) / 2) + name.length()) + "s", name));
    }
}
