package kr.codesquad.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Line {

    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BAR = "|";

    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public void addPoint(int col, Random random) {
        points.add(buildRandomBridge(col, random));
    }

    private Point buildRandomBridge(int col, Random random) {
        if (!existBridgeOnLeft(col) && random.nextBoolean()) {
            return Point.ofBridge();
        }
        return Point.ofEmpty();
    }

    private boolean existBridgeOnLeft(int col) {
        return points.existBridgeOnLeft(col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (Point point : points) {
            line.append(BAR).append(toBridge(point));
        }
        line.append(BAR);
        return line.toString();
    }

    private String toBridge(Point point) {
        if (point.isBridge()) {
            return BRIDGE;
        }
        return EMPTY;
    }
}
