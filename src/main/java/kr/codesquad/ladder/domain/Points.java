package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Points implements Iterable<Point> {

    private final List<Point> points;

    public Points() {
        this(new ArrayList<>());
    }

    public Points(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void add(Point point) {
        points.add(point);
    }

    public boolean existBridgeOnLeft(int col) {
        if (col == 1) {
            return false;
        }
        return points.get(col - 2).isBridge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Points)) {
            return false;
        }
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
