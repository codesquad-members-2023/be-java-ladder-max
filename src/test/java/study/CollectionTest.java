package study;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
    @Test
    @DisplayName("HashSet 학습 테스트")
    public void hashSet() {
        HashSet<Point> points = new HashSet<>();
        points.add(Point.of(1, 1));
        points.add(Point.of(2, 2));
        points.add(Point.of(3, 3));

        assertThat(points.size()).isEqualTo(3);
        assertThat(points.remove(Point.of(2, 2))).isTrue();
        assertThat(points.add(Point.of(2, 2))).isTrue();
        assertThat(points.size()).isEqualTo(3);
    }
}
