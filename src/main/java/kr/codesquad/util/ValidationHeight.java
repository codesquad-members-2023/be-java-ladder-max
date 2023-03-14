package kr.codesquad.util;

public class ValidationHeight {

    public int checkValidation(String input) {
        int checkedNum = checkInteger(input);
        return checkPositive(checkedNum);
    }

    private int checkInteger(String input) {
        int checkedNum;
        try {
            checkedNum = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다. 숫자만 입력해주세요.");
        }
        return checkedNum;
    }

    private int checkPositive(int checkedNum) {
        if(checkedNum <= 0) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다. 양수를 입력해주세요.");
        }
        return checkedNum;
    }
}
