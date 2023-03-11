package kr.codesquad.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionTest {

    @Test
    public void hashSet() {
        HashSet<Point> points = new HashSet<>();
        points.add(Point.of(1, 1));
        points.add(Point.of(2, 2));
        points.add(Point.of(3, 3));

        // 실습 진행
        points.forEach(System.out::print);
        System.out.println();

        Point deletePoint = Point.of(1, 1);
        points.remove(deletePoint);
        points.forEach(System.out::print);

        Point newPoint = Point.of(2, 2);
        points.add(newPoint);
        Assertions.assertThat(points.size()).isEqualTo(2);
    }

    @Test
    public void hashMap() {
        HashMap<Integer, Point> points = new HashMap<>();
        points.put(1, Point.of(1, 1));
        points.put(2, Point.of(3, 5));
        points.put(3, Point.of(5, 7));

        // 실습 진행
        System.out.println(points.get(2));

        Point newPoint = Point.of(10, 15);
        points.put(4, newPoint);
        points.values().forEach(System.out::println);
        points.entrySet().forEach(
            entry -> System.out.printf("key : %d, value : %s%n", entry.getKey(), entry.getValue()));
    }
}

class Point {

    private final int x;
    private final int y;

    private Point(int x, int y) {
        if (x < 0 || x > 24) {
            throw new IllegalArgumentException();
        }
        this.x = x;

        if (y < 0 || y > 24) {
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public static Point ofCommaSeparator(String text) {
        String[] values = text.split(",");
        return new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
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
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
