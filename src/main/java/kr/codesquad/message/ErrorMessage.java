package kr.codesquad.message;

import kr.codesquad.domain.Player;
import kr.codesquad.view.InputView;

public enum ErrorMessage {

    INPUT_IS_EMPTY_ERROR("입력 값이 비어있습니다."),
    INVALID_INPUT_TYPE("숫자만 입력 가능합니다."),
    INVALID_NAME_LENGTH(String.format("이름은 최대 %d까지 입력 가능합니다.", Player.NAME_MAX_LENGTH)),
    INVALID_NAME_DELIMITER(
            String.format("플레이어 이름은 %s(%s)로 구분해 주세요.", InputView.PLAYER_DELIMITER_KR, InputView.PLAYER_DELIMITER)),
    DUPLICATED_PLAYER_NAME("플레이어 이름이 중복됩니다.");

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
