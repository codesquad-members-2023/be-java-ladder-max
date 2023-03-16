package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class CollectionTest {
    @Test
    @DisplayName("HashSet 실습 Test")
    public void hashSet() {
        HashSet<Point> points = new HashSet<>();
        points.add(Point.of(1, 1));
        points.add(Point.of(2, 2));
        points.add(Point.of(3, 3));
        points.add(Point.of(3, 3));


        //1. HashSet의 모든 element를 출력한다.
        System.out.println(points);


        //2. HashSet에서 new Point(1, 1)를 제거한다.
        Point pointToRemove = Point.of(1, 1);
        for (Iterator<Point> iterator = points.iterator(); iterator.hasNext();) {
            Point point = iterator.next();
            if (point.equals(pointToRemove)) {
                iterator.remove();
            }
        }

        Iterator<Point> iterator = points.iterator();
        while (iterator.hasNext()) {
            Point point = iterator.next();
            System.out.println(point);
        }

        //3. HashSet에 new Point(2, 2)를 추가한 후 HashSet의 모든 element 개수를 출력한다.
        points.add(Point.of(2, 2));
        System.out.println(points.size());
    }

    @Test
    @DisplayName("HashMap 실습 Test")
    public void hashMap() {
        HashMap<Integer, Point> points = new HashMap<>();
        points.put(1, Point.of(1, 1));
        points.put(2, Point.of(3, 5));
        points.put(3, Point.of(5, 7));

        System.out.println("points = " + points);

        //1. HashMap에서 key가 2에 해당하는 Point 객체를 찾아 출력한다.
        System.out.println(points.get(2));

        //2. HashMap의 Key는 4, Value는 new Point(10, 15)를 추가하고, HashMap의 모든 Value 값을 출력한다.
        points.put(4,Point.of(10,15));
        System.out.println("points = " + points);

        //3. HashMap의 Key가 3인 값을 삭제한 후, HashMap의 모든 Value 값을 출력한다
        points.remove(3);
        System.out.println("points = " + points);

        //4. HashMap의 모든 Key와 Value를 출력한다.
        for (Map.Entry<Integer, Point> pair : points.entrySet()) {
            System.out.println("key: "+ pair.getKey()+" value:  "+pair.getValue());
        }
    }
}
