package kr.codesquad.util;


import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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

    public List<String> validateInputNames(String names) throws IOException {
        String[] userNames = names.split(",");
        validateInputString(userNames);
        return List.of(userNames);
    }

    // ^[a-zA-Z]*$
    private void validateInputString(String[] userNames) throws IOException {
        String regex = "^[a-zA-Z]*$";
        String allUserNames = String.join("", userNames);
        boolean nameCheck = Pattern.matches(regex, allUserNames);
        if (!nameCheck) {
            throw new IOException("이름은 알파벳으로 입력해야 합니다. 다시 입력해 주십시오");
        }
    }


}
