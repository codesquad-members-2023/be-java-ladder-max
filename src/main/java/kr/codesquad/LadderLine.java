package kr.codesquad;

import java.util.Random;

public enum LadderLine {
    VERTICAL("|"), HORIZONTAL("-----"), BLANK("     ");
    
    private final String line;

    LadderLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
