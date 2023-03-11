package kr.codesquad.exception.result;

public class ResultsMinSizeException extends RuntimeException {

    @Override
    public String getMessage() {
        return "실행 결과의 갯수는 최소 2개입니다.";
    }
}
