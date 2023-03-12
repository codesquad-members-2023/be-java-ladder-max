package kr.codesquad.exception.result;

import kr.codesquad.domain.Result;

public class ResultMaxLengthException extends RuntimeException {

    @Override
    public String getMessage() {
        return String.format("결과는 최대 %d글자입니다.", Result.MAX_LENGTH);
    }
}
