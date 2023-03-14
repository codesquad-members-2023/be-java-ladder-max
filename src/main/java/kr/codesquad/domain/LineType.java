package kr.codesquad.domain;

public enum LineType {
    FALSE(false, "     "),
    TRUE(true, "-----");

    private boolean isPoint;
    private String line;

    LineType(boolean isPoint, String line) {
        this.isPoint = isPoint;
        this.line = line;
    }
}
