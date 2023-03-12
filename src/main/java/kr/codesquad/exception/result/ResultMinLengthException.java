package kr.codesquad.exception.result;

import kr.codesquad.domain.Result;

public class ResultMinLengthException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("결과는 최소 %d글자 입니다.", Result.MIN_LENGTH);
    }
}
