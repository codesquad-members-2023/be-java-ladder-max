package kr.codesquad.domain;

import kr.codesquad.exception.ladder.LadderMinHeightException;

public class LadderHeight {

    public static final int MIN_HEIGHT = 2;

    private final int height;

    public LadderHeight(int height) {
        validateMinHeight(height);
        this.height = height;
    }

    private void validateMinHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new LadderMinHeightException();
        }
    }

    public int getHeight() {
        return this.height;
    }
}
