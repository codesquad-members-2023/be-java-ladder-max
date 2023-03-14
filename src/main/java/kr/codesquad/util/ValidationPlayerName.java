package kr.codesquad.util;

import java.util.Set;

public class ValidationPlayerName {

    /*
    정규표현식에서 ^는 시작, $는 끝을 알리는 표시
    a-z 영문 소문자, A-Z 영문 대문자, 0-9 숫자, \p{IsHangul} 한글
    " + min_length + "," + max_length + " : 글자수 min~max length 사이의 문자열
 */
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String VALID_PLAYER_NAME = "^[a-zA-Z0-9\\p{IsHangul}]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

    public void checkNameFormat(String parsingNames) {
        if (!parsingNames.matches(VALID_PLAYER_NAME)) {
            throw new IllegalArgumentException("올바른 형식이 아닙니다. 1~5 글자의 이름을 입력해주세요.");
        }
    }

    public void checkNameDuplication(int playerNumber, Set<String> setNameList) {
        if(playerNumber != setNameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다. 다시 입력해주세요.");
        }
    }
}
