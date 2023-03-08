package study;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class CollectionTest {

    public void hashSet() {
        HashSet<Point> points = new HashSet<>();
        points.add(Point.of(1,1));
        points.add(Point.of(2,2));
        points.add(Point.of(3,3));

        System.out.println(points.remove(Point.of(1,1)));

        for(Point point : points){
            System.out.println(point);
        }

        points.add(Point.of(2,2));
        System.out.println(points.size());
    }

    @Test
    public void hashMap() {
        HashMap<Integer, Point> points = new HashMap<>();
        points.put(1, Point.of(1, 1));
        points.put(2, Point.of(3, 5));
        points.put(3, Point.of(5, 7));

        System.out.println(points.get(2));

        points.put(4, Point.of(10, 15));

        for(Point val : points.values()){
            System.out.println(val);
        }

        points.remove(3);

        for(int key : points.keySet()){
            System.out.println("key : " + key + ", value : " + points.get(key));
        }
    }
}
