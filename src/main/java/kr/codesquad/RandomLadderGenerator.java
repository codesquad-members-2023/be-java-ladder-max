package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class RandomLadderGenerator {
  private final Random random = new Random();

  public Ladder generate(int sizeOfPeople, int sizeOfLadder) {
    ArrayList<ArrayList<Boolean>> ladder = new ArrayList<>(sizeOfLadder);
    for (int row = 0; row < sizeOfLadder; row++) {
      ladder.add(new ArrayList<>());
      ladder.get(row).add(random.nextBoolean());
      for (int col = 1; col < sizeOfPeople-1; col++) {
        boolean hasLine = ladder.get(row).get(col-1) ? false : random.nextBoolean(); // 이전 열의 라인 유무확인
        ladder.get(row).add(hasLine);
      }
      ladder.get(row).add(false); // 마지막 열은 라인이 없으므로 false를 저장한다.
    }

    return new Ladder(ladder);
  }
}
