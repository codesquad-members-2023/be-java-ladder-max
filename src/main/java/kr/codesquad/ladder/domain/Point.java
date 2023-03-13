package kr.codesquad.ladder.domain;

import java.util.Objects;

public class Point {

    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BAR = "|";

    private final String value;

    private Point(String value) {
        this.value = value;
    }

    public static Point ofBar() {
        return new Point(BAR);
    }

    public static Point ofBridge() {
        return new Point(BRIDGE);
    }

    public static Point ofEmpty() {
        return new Point(EMPTY);
    }

    public boolean isBridge() {
        return value.equals(BRIDGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(value, point.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
