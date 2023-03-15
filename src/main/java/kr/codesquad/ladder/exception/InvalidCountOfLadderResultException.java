package kr.codesquad.ladder.exception;

public class InvalidCountOfLadderResultException extends RuntimeException {

    private static final String message = "실행결과의 개수는 참여할 사람 이름수와 동일해야 합니다. 개수 : %d";

    public InvalidCountOfLadderResultException(int countOfPeople) {
        super(String.format(message, countOfPeople));
    }
}
