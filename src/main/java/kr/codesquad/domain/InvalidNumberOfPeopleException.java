package kr.codesquad.domain;

public class InvalidNumberOfPeopleException extends RuntimeException {

    private static final String message = "참여할 사람은 최소 2명 이상이어야 합니다. 다시 입력해주세요.";

    public InvalidNumberOfPeopleException() {
        super(message);
    }

}
