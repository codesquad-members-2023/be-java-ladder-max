package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public Point get(int index) {
        return points.get(index);
    }

    public boolean existBridgeOnLeft(int col) {
        if (col == 0) {
            return false;
        }
        return points.get(col - 1).isBridge();
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
