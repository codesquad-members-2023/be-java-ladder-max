package kr.codesquad.ladder.exception;

public class InvalidContainOfNamesException extends RuntimeException {

    private static final String message = "해당 사람은 사다리 게임 이름에 없습니다. 다시 입력해주세요.";

    public InvalidContainOfNamesException() {
        super(message);
    }
}
