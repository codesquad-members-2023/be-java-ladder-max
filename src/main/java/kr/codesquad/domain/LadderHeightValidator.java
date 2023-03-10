package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;

public class LadderHeightValidator {

    private final String errorMessageForLadderHeight = "사다리 높이는 1이상으로 입력";
    public boolean getValidHeightFromUser(ArrayList list, InputView inputHandler) {
        try {
            String height = inputHandler.getInput();
            list.add(validateHeightAndThrowException(height));
            return true;
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private String validateHeightAndThrowException(String height) {
        if (Integer.parseInt(height) < 1) {
            throw new RuntimeException(errorMessageForLadderHeight);
        }
        return height;
    }
}
