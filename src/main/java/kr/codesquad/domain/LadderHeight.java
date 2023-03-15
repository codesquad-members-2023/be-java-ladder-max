package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;

public class LadderHeight {

    private int ladderHeight;

    public int getLadderHeight() {
        return ladderHeight;
    }

    private final String ERROR_MESSAGE_FOR_LADDER_HEIGHT = "사다리 높이는 1이상으로 입력";
    public boolean getValidHeightFromUser(int ladderHeight) {
        try {
            this.ladderHeight =validateHeightAndThrowException(ladderHeight) ;
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private int validateHeightAndThrowException(int height) {
        if (height < 1) {
            throw new RuntimeException(ERROR_MESSAGE_FOR_LADDER_HEIGHT);
        }
        return height;
    }
}
