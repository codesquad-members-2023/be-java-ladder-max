package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBooleanGenerator {
    private final Random rnd = new Random();

    public List<Boolean> generate(int size) {
        List randomBoolean = new ArrayList();

        for (int cnt = 0; cnt < size; cnt++) {
            boolean whatToAdd = rnd.nextBoolean();
            addBooleanWithoutContinuity(randomBoolean, whatToAdd);
        }
        return randomBoolean;
    }

    private void addBooleanWithoutContinuity(List<Boolean> whereToAdd, boolean whatToAdd) {
        if (isTrueContinuous(whereToAdd, whatToAdd)) {
            whereToAdd.add(false);
            return;
        }
        whereToAdd.add(whatToAdd);
    }

    private boolean isTrueContinuous(List<Boolean> comparableList, boolean comparableBoolean) {
        if (comparableList.isEmpty()) {
            return false;
        }
        if (comparableList.get(comparableList.size() - 1) && comparableBoolean) {
            return true;
        }
        return false;
    }
}
