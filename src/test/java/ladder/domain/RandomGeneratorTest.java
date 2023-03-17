package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

	@DisplayName("사람수가 주어졌을 때 연속된 사다리 라인이 있는지 확인한다")
	@Test
	void randomLine () {
		//given
		RandomGenerator randomGenerator = new RandomGenerator();
		int countOfPerson = 4;

		//when
		List<String> horizontalLadder = randomGenerator.remakeLadder(countOfPerson);

		//then
		assertThat(horizontalLadder).doesNotContainSequence("-----", "-----");
	}
}