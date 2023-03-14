package kr.codesquad.domain;

public enum LadderLine {
    VerticalLine("|"),
    StraightLine("-----"),
    BlankLine("     ");

    private final String value;

    LadderLine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
