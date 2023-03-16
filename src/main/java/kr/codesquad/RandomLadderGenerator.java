package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class RandomLadderGenerator {
    private final Random random = new Random();

    public Ladder generate(int sizeOfPeople, int sizeOfLadder) {
        ArrayList<Line> ladder = new ArrayList<>();
        while (sizeOfLadder-- > 0) {
            Line line = new Line();
            line.add(random.nextBoolean());
            for (int col = 1; col < sizeOfPeople - 1; col++) {
                // 이전 열의 라인 유무확인
                line.add(line.hasBridge(col - 1) ? false : random.nextBoolean());
            }
            line.add(false); // 마지막 열은 라인이 없으므로 false를 저장한다.
            ladder.add(line);
        }
        return new Ladder(ladder);
    }
}
