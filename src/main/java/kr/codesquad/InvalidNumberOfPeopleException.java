package kr.codesquad;

public class InvalidNumberOfPeopleException extends RuntimeException {

    private static final String message = "적절하지 않은 입력입니다. 최소 2명 이상의 사람을 입력해주세요.";

    public InvalidNumberOfPeopleException() {
        super(message);
    }

}
