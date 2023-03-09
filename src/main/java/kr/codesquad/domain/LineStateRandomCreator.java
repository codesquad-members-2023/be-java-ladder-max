package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineStateRandomCreator {

    private final Random random;

    public LineStateRandomCreator() {
        random = new Random();
    }

    public List<List<Boolean>> create(int namesSize, int ladderHeight) {
        List<List<Boolean>> linesStateInfo = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            linesStateInfo.add(randomLineStateInfo(namesSize));
        }
        return linesStateInfo;
    }

    private List<Boolean> randomLineStateInfo(int namesSize) {
        List<Boolean> result = new ArrayList<>();
        boolean possible = true;
        for (int j = 0; j < namesSize - 1; j++) {
            possible = !(random.nextBoolean() && possible);
            result.add(!possible);
        }
        return result;
    }
}
