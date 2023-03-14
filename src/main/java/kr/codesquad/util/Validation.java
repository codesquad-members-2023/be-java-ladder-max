package kr.codesquad.util;


import kr.codesquad.domain.Users;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private final String STRING_SPLIT = ",";
    private final String REGEX = "^[a-zA-Z]*$";
    private final String EMPTY_STRING = "";
    private final int MAX_NAME_SIZE = 5;
    private final int MIN_NUMBER_SIZE = 0;

    public Users validateInputNames(String names) throws IOException {
        String[] userNames = names.split(STRING_SPLIT);
        validateInputString(userNames);
        validateInputNameSize(userNames);
        return new Users(userNames);
    }

    private void validateInputString(String[] userNames) throws IOException {
        String allUserNames = String.join(EMPTY_STRING, userNames);
        boolean nameCheck = Pattern.matches(REGEX, allUserNames);
        if (!nameCheck) {
            throw new IOException("이름은 알파벳으로 입력해야 합니다. 다시 입력해 주십시오");
        }
    }

    private void validateInputNameSize(String[] userNames) throws IOException {
        for (String userName : userNames) {
            validateNameMaxSize(userName);
        }
    }

    private void validateNameMaxSize(String userName) throws IOException {
        if (userName.length() > MAX_NAME_SIZE) {
            throw new IOException("이름은 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public int validateInputLadderNumber(String ladderNumber) {
        int input = validateInputInteger(ladderNumber);
        return validateInputPositive(input);
    }

    private int validateInputInteger(String beforeInput) {
        int result;
        try {
            result = Integer.parseInt(beforeInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다. 정수로 다시 입력해 주십시오.");
        }
        return result;
    }

    private int validateInputPositive(int input) {
        if (input <= MIN_NUMBER_SIZE) {
            throw new NumberFormatException("잘못된 입력입니다. 양수로 다시 입력해 주십시오");
        }
        return input;
    }
}
