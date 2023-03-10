package kr.codesquad.domain;

public class InvalidNameOfPeopleException extends RuntimeException {

    private static final String message = "참여할 사람의 이름은 영어 최대 5글자로 구성되어야 합니다. 다시 입력해주세요";

    public InvalidNameOfPeopleException() {
        super(message);
    }
}
