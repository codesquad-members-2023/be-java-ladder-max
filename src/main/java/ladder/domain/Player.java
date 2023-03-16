package ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        final int MAX = 5;
        if (name.length() > MAX) {
            throw new IllegalArgumentException("이름의 길이는 최대 5글자입니다.");
        }
    }

    public String makeNameLabel(int size) {
        StringBuilder builder = new StringBuilder();
        int frontBlank = (size - name.length()) / 2;
        int backBlank = (size - name.length()) % 2;
        builder.append(" ".repeat(frontBlank));
        builder.append(name);
        builder.append(" ".repeat(frontBlank + backBlank));
        return builder.toString();
    }
}
