package kr.codesquad.exception.result;

public class ResultsSizeSameUserCountException extends RuntimeException {

    @Override
    public String getMessage() {
        return "실행 결과의 갯수와 참여할 사람 수는 같아야 합니다.";
    }
}
