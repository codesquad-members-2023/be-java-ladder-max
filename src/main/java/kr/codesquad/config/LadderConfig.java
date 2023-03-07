package kr.codesquad.config;

import kr.codesquad.domain.Player;

public enum LadderConfig {

    AFFIX(-1, "|"), // TODO: enum에서 숫자를 비워두는 방법...이 있나?
    EMPTY(0, " ".repeat(Player.NAME_MAX_LENGTH)),
    LADDER(1, "-".repeat(Player.NAME_MAX_LENGTH));

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
