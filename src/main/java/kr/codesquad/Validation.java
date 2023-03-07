package kr.codesquad;

public class Validation {

    public int validationInputN(String n) {
        int input = validationInputInteger(n);
        return validationInputPositive(input);
    }

    public int validationInputM(String m) {
        int input = validationInputInteger(m);
        return validationInputPositive(input);    }

    public int validationInputInteger(String beforeInput) {
        int result = -1;
        try {
            result = Integer.parseInt(beforeInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다. 정수로 다시 입력해 주십시오.");
        }
        return result;
    }
    private int validationInputPositive(int input) {
        if (input <= 0) {
            throw new NumberFormatException("잘못된 입력입니다. 양수로 다시 입력해 주십시오");
        }
        return input;
    }
}
