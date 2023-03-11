package kr.codesquad.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Line {

    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BAR = "|";

    private final Points points;
    private final Random random;

    public Line(int numberOfPerson, Random random) {
        this.random = random;
        this.points = new Points();
        for (int i = 0; i < numberOfPerson - 1; i++) {
            points.add(buildRandomBridge(i));
        }
    }

    public Line(Points points, Random random) {
        this.points = points;
        this.random = random;
    }

    private Point buildRandomBridge(int col) {
        if (!existBridgeOnLeft(col) && random.nextBoolean()) {
            return Point.ofBridge();
        }
        return Point.ofEmpty();
    }

    private boolean existBridgeOnLeft(int col) {
        if (col == 0) {
            return false;
        }
        return getLeftColumn(col).isBridge();
    }

    private Point getLeftColumn(int col) {
        return points.get(col - 1);
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
