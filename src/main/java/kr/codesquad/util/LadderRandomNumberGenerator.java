package kr.codesquad.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kr.codesquad.config.LadderConfig;

public class LadderRandomNumberGenerator implements NumberGenerator {

    private static final Random random = ThreadLocalRandom.current();

    private static final int START_INCLUSIVE = LadderConfig.EMPTY.number();
    private static final int END_INCLUSIVE = LadderConfig.LADDER.number();

    @Override
    public int generate() {
        return START_INCLUSIVE + random.nextInt(END_INCLUSIVE - START_INCLUSIVE + 1);
    }

}
