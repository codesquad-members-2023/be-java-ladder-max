package kr.codesquad.ladder.exception;

public class InvalidCountOfDestinationsException extends RuntimeException {

    private static final String message = "도착지의 개수는 참여할 사람 이름수와 동일해야 합니다. 개수 : %d";

    public InvalidCountOfDestinationsException(int countOfPeople) {
        super(String.format(message, countOfPeople));
    }
}
