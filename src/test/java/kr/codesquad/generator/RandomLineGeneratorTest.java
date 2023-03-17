package kr.codesquad.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 라인 생성기 테스트")
class RandomLineGeneratorTest {

	private RandomLineGenerator randomLineGenerator = new RandomLineGenerator();

	@DisplayName("사람 수가 주어졌을 때 연속된 라인을 생성하는지 검증한다.")
	@Test
	void assertIsCreateContinuousLine() {
		// given
		int countOfPerson = 100;

		// when
		List<Boolean> points = randomLineGenerator.drawLineRandomly(countOfPerson);

		// then
		assertThat(points).doesNotContainSequence(true, true);
	}
}