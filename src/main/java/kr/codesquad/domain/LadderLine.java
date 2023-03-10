package kr.codesquad.domain;

import java.util.Random;

public enum LadderLine {
    stick("-----"),
    blank("     ");

    private String value;

    LadderLine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String takeRandom() {
        return LadderLine.values()[new Random().nextInt(LadderLine.values().length)].getValue();
    }
}
