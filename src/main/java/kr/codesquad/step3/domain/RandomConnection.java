package kr.codesquad.step3.domain;

import java.util.Random;

public class RandomConnection {
    private static final Random random = new Random();

    public boolean connect() {
        return random.nextBoolean();
    }
}
