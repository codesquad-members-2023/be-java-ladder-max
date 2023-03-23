package kr.codesquad.domain;

public class Point {
    private final int startWidth;

    private int currentWidth;

    public Point(int startWidth) {
        this.startWidth = startWidth;
        this.currentWidth = startWidth;
    }

    public int getStartLadderNumber() {
        return startWidth / 2;
    }

    public int getFinalLadderNumber() {
        return currentWidth / 2;
    }

    public int getCurrentWidth() {
        return currentWidth;
    }

    public void move(int width) {
        currentWidth += width;
    }
}
