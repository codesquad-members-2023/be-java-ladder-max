package kr.codesquad.domain;

public enum Direction {
    LEFT(-2),
    RIGHT(2),
    NONE(0);

    private final int unitVector;

    Direction(int unitVector) {
        this.unitVector = unitVector;
    }

    public int getUnitVector() {
        return unitVector;
    }
}
