package kr.codesquad.message;

public enum ErrorMessage {

    INPUT_IS_EMPTY_ERROR("입력 값이 비어있습니다."),
    INVALID_INPUT_TYPE("숫자만 입력 가능합니다.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
