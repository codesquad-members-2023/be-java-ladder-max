package kr.codesquad.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputLadderHeightManager {

    private  Scanner scanner;

    static final String GET_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    static final String LADDER_HEIGHT_INPUT_ERROR_MESSAGE = "입력이 틀렸습니다. 1 이상의 정수형을 입력해주세요";

    static final int LADDER_HEIGHT_NULL_CODE = -1;
    static final int MINIMUM_LADDER_HEIGHT = 1;

    public InputLadderHeightManager(Scanner scanner){
         this.scanner = scanner;
    }


    public int inputLadderHeight() {
        try {
            return isValidLadderHeight(getIntegerInput());
        } catch (InputMismatchException exception) {
            scanner.next();
            System.out.println(LADDER_HEIGHT_INPUT_ERROR_MESSAGE);
            return LADDER_HEIGHT_NULL_CODE;
        }
    }

    public int isValidLadderHeight(int ladderHeight) {
        if (ladderHeight >= MINIMUM_LADDER_HEIGHT) {
            return ladderHeight;
        }
        return LADDER_HEIGHT_NULL_CODE;
    }

    public boolean checkNullLadderHeight(int ladderHeight){
        return ladderHeight != LADDER_HEIGHT_NULL_CODE;
    }

    public int getIntegerInput() {
        return scanner.nextInt();
    }
}
