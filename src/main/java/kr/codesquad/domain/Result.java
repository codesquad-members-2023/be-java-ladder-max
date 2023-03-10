package kr.codesquad.domain;

public class Result {

    private static final int MIN_LENGTH = 1;

    private final String result;

    public Result(String result) {
        validateMinLength(result);
        this.result = result;
    }

    private void validateMinLength(String result) {
        if (result.isBlank() && result.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("최소 1글자 이상 이어야 합니다.");
        }
    }

    public String printFormat() {
        int totalLength = 6;
        int nameLength = this.result.length();
        int leftPadding = ((totalLength - nameLength) / 2) + ((totalLength - nameLength) % 2);
        int rightPadding = (totalLength - nameLength) / 2;
        return String.format("%s%s%s", " ".repeat(leftPadding), this.result, " ".repeat(rightPadding));
    }

    @Override
    public String toString() {
        return this.result;
    }
}
