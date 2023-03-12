package kr.codesquad.Model;

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
