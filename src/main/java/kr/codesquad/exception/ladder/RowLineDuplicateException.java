package kr.codesquad.exception.ladder;

public class RowLineDuplicateException extends RuntimeException {

    @Override
    public String getMessage() {
        return "가로 사다리 라인이 곁치지 않아야 합니다.";
    }
}
