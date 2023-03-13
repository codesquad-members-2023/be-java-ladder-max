package kr.codesquad.domain;

public enum LineDelimiterType {
    SUCCESS_DELIMITER("------"),FAIL_DELIMITER("          "),PEOPLE_DELIMITER("|");

    private final String value;

    LineDelimiterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
