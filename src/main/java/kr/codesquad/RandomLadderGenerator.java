package kr.codesquad;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomLadderGenerator {
  private final Random random = new Random();

  public Ladder generate(int sizeOfPeople, int sizeOfLadder) {
    boolean[][] ladder = new boolean[sizeOfLadder][sizeOfPeople];
    for (int row = 0; row < sizeOfLadder; row++) {
      for (int col = 0; col < sizeOfPeople-1; col++) {
        ladder[row][col] = random.nextBoolean();
      }
    }

    return new Ladder(ladder);
  }
}
