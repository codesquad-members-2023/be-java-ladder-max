package kr.codesquad.ladder.exception;

public class InvalidFormatOfDestinationException extends RuntimeException {

    private static final String message = "실행결과의 길이는 최대 5글자입니다. 다시 입력해주세요.";

    public InvalidFormatOfDestinationException() {
        super(message);
    }
}
