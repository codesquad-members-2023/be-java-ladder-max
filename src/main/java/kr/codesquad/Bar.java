package kr.codesquad;

public enum Bar {
    VERTICAL("|"), HORIZONTAL("-----"), BLANK("     ");
    
    private final String line;

    Bar(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
