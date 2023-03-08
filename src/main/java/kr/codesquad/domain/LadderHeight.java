package kr.codesquad.domain;

public class LadderHeight {

    private static final int MIN_HEIGHT = 2;

    private final int height;

    public LadderHeight(int height) {
        validateMinHeight(height);
        this.height = height;
    }

    private void validateMinHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 2이상 입니다.");
        }
    }

    public int getHeight() {
        return this.height;
    }
}
