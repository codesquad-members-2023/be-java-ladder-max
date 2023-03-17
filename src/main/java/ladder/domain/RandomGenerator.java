package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* test 를 위해 LadderLine class 에서 remakeLadder 와 randomLadder 메서드를
RandomGenerator class 생성 후 옮겨놓음
 */
public class RandomGenerator {
	public List<String> remakeLadder(int countOfPerson) {
		List<String> ladder = new ArrayList<>();
		for (int i = 0; i < countOfPerson- 1; i++) {
			ladder.add(randomLadder(i, ladder));
		}
		return ladder;
	}

	private String randomLadder(int index, List<String> ladder) {
		String[] indexRandom = {"     ", "-----"};
		Random random = new Random();
		if (index == 0) {
			return indexRandom[random.nextInt(2)];
		}
		if (ladder.get(index-1).equals("     ")) {
			return indexRandom[random.nextInt(2)];
		}
		return "     ";
	}
}
