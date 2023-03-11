package kr.codesquad.domain;

import java.util.Objects;

public class Result {

    public static final int MIN_LENGTH = 1;

    private final String result;

    public Result(String result) {
        String NotBlankResult = result.replace(" ", "");
        validateMinLength(NotBlankResult);
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result1 = (Result) o;
        return result.equals(result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return this.result;
    }
}
