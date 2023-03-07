package kr.codesquad.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 라인 생성기 테스트")
class RandomLineGeneratorTest {

	private RandomLineGenerator randomLineGenerator = new RandomLineGenerator();

	@DisplayName("사람 수가 주어졌을 때 연속된 라인을 생성하는지 검증한다.")
	@Test
	void assertIsCreateContinuousLine() {
		int countOfPerson = 5;

		List<Boolean> points = randomLineGenerator.drawLineRandomly(countOfPerson);
		List<Integer> existsPointPoses = new ArrayList<>();
		for (int i = 0; i < countOfPerson - 1 && points.get(i); i++) {
			existsPointPoses.add(i);
		}

		// assert
		for (Integer existsPointPos : existsPointPoses) {
			assertThat(points.get(existsPointPos + 1)).isFalse();
		}
	}
}