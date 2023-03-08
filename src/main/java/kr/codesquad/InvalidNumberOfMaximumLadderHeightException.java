package kr.codesquad;

public class InvalidNumberOfMaximumLadderHeightException extends RuntimeException {

    private static final String message = "적절하지 않은 입력입니다. 1 이상의 사다리 높이를 입력해주세요.";

    public InvalidNumberOfMaximumLadderHeightException() {
        super(message);
    }
}
