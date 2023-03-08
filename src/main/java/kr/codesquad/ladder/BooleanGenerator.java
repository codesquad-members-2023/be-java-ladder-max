package kr.codesquad.ladder;

import java.util.stream.Stream;

public class BooleanGenerator {

    public static boolean randomBoolean() {
        return Stream.generate(() -> (int) (Math.random() * 2))
                .limit(1)
                .anyMatch(value -> value == 1);
    }
}
