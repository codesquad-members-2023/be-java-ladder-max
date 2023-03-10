package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int countPlayerNum() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        String number = br.readLine();
        return checkValidation(number);
    }

    public int countMaxHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String height = br.readLine();
        return checkValidation(height);
    }

    private int checkValidation(String input) {
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
