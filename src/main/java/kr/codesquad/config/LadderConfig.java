package kr.codesquad.config;

public enum LadderConfig {

    AFFIX(-1, "|"), // TODO: enum에서 숫자를 비워두는 방법...이 있나?
    EMPTY(0, " "),
    LADDER(1, "-");

    private final int number;
    private final String expression;

    LadderConfig(int number, String expression) {
        this.number = number;
        this.expression = expression;
    }

    public int number() {
        return number;
    }

    public String expression() {
        return expression;
    }
}
