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

    public int climb(int col) {
        boolean[] visited = new boolean[points.size()];
        return climbUtil(col, visited);
    }

    // TODO: depth2 -> depth1 줄이기
    private int climbUtil(int col, boolean[] visited) {
        visited[col] = true;
        List<Integer> adjacentColumns = getAdjacentColumns(col);

        for (int adjacentColumn : adjacentColumns) {
            if (visited[adjacentColumn]) {
                continue;
            }
            if (isEmptyColumn(adjacentColumn)) {
                continue;
            }
            return climbUtil(adjacentColumn, visited);
        }
        return col;
    }

    private List<Integer> getAdjacentColumns(int col) {
        List<Integer> adjacentColumns = new ArrayList<>();

        if (col > 0) {
            adjacentColumns.add(col - 1);
        }
        if (col < points.size() - 1) {
            adjacentColumns.add(col + 1);
        }
        return adjacentColumns;
    }

    private boolean isEmptyColumn(int col) {
        return points.get(col).isEmpty();
    }
}
