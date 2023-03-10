package kr.codesquad.domain;

public enum SearchType {
    ALL("all"),
    CLOSE("춘식이"),
    SINGLE("single");
    private final String value;

    SearchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
