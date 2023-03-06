package kr.codesquad;

public class Validation {
    public int[] validationInput(String n, String m) {
        int resultN = -1;
        int resultM = -1;
        try {
            resultN = Integer.parseInt(n);
            resultM = Integer.parseInt(m);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다. 정수로 다시 입력해 주십시오.");
        }
        return new int[]{resultN, resultM};
    }

    public int validationInputN(String n) {
        return validationInput(n);
    }

    public int validationInputM(String m) {
        return validationInput(m);
    }

    public int validationInput(String beforeInput) {
        int result = -1;
        try {
            result = Integer.parseInt(beforeInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 입력입니다. 정수로 다시 입력해 주십시오.");
        }
        return result;
    }
}
