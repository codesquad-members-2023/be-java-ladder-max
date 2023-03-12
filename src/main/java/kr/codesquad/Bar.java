package kr.codesquad;

public enum Bar {
    VERTICAL("|"), HORIZONTAL("-----"), BLANK("     ");
    
    private final String bar;

    Bar(String bar) {
        this.bar = bar;
    }

    public String getBar() {
        return bar;
    }
}
