package kr.codesquad.ladder.domain;

import java.util.Objects;

public class Point {

    private final boolean bridge;

    public Point(boolean bridge) {
        this.bridge = bridge;
    }

    public boolean isBridge() {
        return bridge;
    }

    public static Point ofBridge() {
        return new Point(true);
    }

    public static Point ofEmpty() {
        return new Point(false);
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
        return isBridge() == point.isBridge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBridge());
    }
}
