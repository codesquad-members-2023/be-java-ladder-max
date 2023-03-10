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

    public String getResult() {
        return result;
    }
}
