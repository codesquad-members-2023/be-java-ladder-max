package ladder.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomManager {
    private Random random = new Random();

    public List<Boolean> makeBooleansRandomly(int size) {
        List<Boolean> booleans = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            booleans.add(random.nextBoolean());
        }
        return booleans;
    }
}
