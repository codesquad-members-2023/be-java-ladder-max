package kr.codesquad;

public class InvalidPersonNumber extends RuntimeException {

    private static final String message = "적절하지 않은 입력입니다. 최소 2명 이상의 사람을 입력해주세요.";

    public InvalidPersonNumber() {
        super(message);
    }

}
