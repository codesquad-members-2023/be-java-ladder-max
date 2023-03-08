package kr.codesquad;

public enum LadderLine {
    VERTICAL("|"),
    HORIZONTAL("-");
    
    private String line;

    LadderLine(String line) {
        this.line = line;
    }
}
