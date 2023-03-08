package kr.codesquad.util;


import java.util.List;

public class Validation {

    public int validateInputN(String n) {
        int input = validateInputInteger(n);
        return validateInputPositive(input);
    }

    public int validateInputM(String m) {
        int input = validateInputInteger(m);
        return validateInputPositive(input);    }

    private int validateInputInteger(String beforeInput) {
        int result = -1;
        try {
            result = Integer.parseInt(beforeInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다. 정수로 다시 입력해 주십시오.");
        }
        return result;
    }

    private int validateInputPositive(int input) {
        if (input <= 0) {
            throw new NumberFormatException("잘못된 입력입니다. 양수로 다시 입력해 주십시오");
        }
        return input;
    }


}
