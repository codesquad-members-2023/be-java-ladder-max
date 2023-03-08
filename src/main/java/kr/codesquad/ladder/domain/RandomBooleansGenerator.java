package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomBooleansGenerator {

    private static final Random random = new Random();

    public List<Boolean> createRandomBooleans(int size) {
        List<Boolean> booleans;
        do {
            booleans = randomBoolean(size);
        } while (containsConsecutiveTrue(booleans));
        return booleans;
    }


    private List<Boolean> randomBoolean(int size) {
        return Stream.generate(() -> random.nextBoolean())
                .limit(size)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean containsConsecutiveTrue(List<Boolean> booleans) {
        for (int i = 1; i < booleans.size(); i++) {
            if (booleans.get(i) && booleans.get(i - 1)) {
                return true;
            }
        }
        return false;
    }
}
