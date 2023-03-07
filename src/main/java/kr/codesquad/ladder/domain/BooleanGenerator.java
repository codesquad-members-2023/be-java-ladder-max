package kr.codesquad.ladder.domain;

import java.util.Random;

public class BooleanGenerator {

    private static Random random = new Random();

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }
}
