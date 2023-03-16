package kr.codesquad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderGeneratorTest {
  @Test
  @DisplayName("랜덤하게 생성시 사다리의 라인은 겹치지 않습니다.")
  public void testRandomGenerate() {
    RandomLadderGenerator generator = new RandomLadderGenerator();
    var ladder = generator.generate(5, 5);
    for (var row : ladder.getLadder()) {
      for (int i = 1 ; i < row.size()-1 ; i++) {
        // 현재위치와 앞 또는 뒤 위치에 라인이 모두 있는 경우는 없습니다.
        assertFalse(row.get(i) && row.get(i-1));
        assertFalse(row.get(i) && row.get(i+1));
      }
    }
  }

  @Test
  @DisplayName("사다리의 마지막 열은 라인이 없습니다.")
  public void testLastRow() {
    RandomLadderGenerator generator = new RandomLadderGenerator();
    var ladder = generator.generate(5, 5);
    for (var row : ladder.getLadder()) {
      assertFalse(row.get(4));
    }
  }
}