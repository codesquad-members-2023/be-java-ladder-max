package kr.codesquad.ladder;

import java.util.Random;
import java.util.stream.Stream;

public class BooleanGenerator {

    private static Random random = new Random();

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }
}
