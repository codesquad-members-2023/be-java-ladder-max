package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;

public class LadderHeight {

    private final String ERROR_MESSAGE_FOR_LADDER_HEIGHT = "사다리 높이는 1이상으로 입력";
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
            throw new RuntimeException(ERROR_MESSAGE_FOR_LADDER_HEIGHT);
        }
        return height;
    }
}
