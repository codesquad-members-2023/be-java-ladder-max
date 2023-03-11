package kr.codesquad.domain;

import java.util.Objects;
import kr.codesquad.exception.result.ResultMaxLengthException;
import kr.codesquad.exception.result.ResultMinLengthException;

public class Result {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String result;

    public Result(String result) {
        String NotBlankResult = result.replace(" ", "");
        validateMinLength(NotBlankResult);
        validateMaxLength(NotBlankResult);
        this.result = NotBlankResult;
    }

    private void validateMaxLength(String result) {
        if (result.length() > MAX_LENGTH) {
            throw new ResultMaxLengthException();
        }
    }

    private void validateMinLength(String result) {
        if (result.length() < MIN_LENGTH) {
            throw new ResultMinLengthException();
        }
    }

    public String printFormat() {
        int totalLength = MAX_LENGTH + 1;
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
