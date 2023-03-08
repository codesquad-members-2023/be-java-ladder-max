package kr.codesquad.domain;

import java.util.Random;

public class RandomUtil {
    private final Random random;
    RandomUtil() {
        this.random = new Random();
    }

    public boolean getBoolean() {
        return random.nextBoolean();
    }
}
