package kr.codesquad.domain;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0), // 직진한 경우(원래 인덱스에 머무름)
    RIGHT(+1);

    private final int directionIndex;

    Direction(final int directionIndex) {
        this.directionIndex = directionIndex;
    }
}
