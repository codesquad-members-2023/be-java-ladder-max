package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 높이 도메인 테스트")
class HeightTest {

	@DisplayName("올바른 사다리 높이가 주어지면 생성에 성공한다.")
	@Test
	void givenRightHeight_whenCreateHeight_thenSuccessCreate() {
		// given
		String rightHeight = "5";

		// when & then
		assertThatCode(() -> new Height(rightHeight))
			.doesNotThrowAnyException();
	}

	@DisplayName("1미만의 사다리 높이가 주어지면 예외를 던진다.")
	@Test
	void givenUnderHeight_whenCreateHeight_thenThrowsException() {
		// given
		String underHeight = "0";

		// when & then
		assertThatThrownBy(() -> new Height(underHeight))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아닌 사다리 높이가 주어지면 예외를 던진다.")
	@Test
	void test() {
		// given
		String notDigitHeight = "A";

		// when & then
		assertThatThrownBy(() -> new Height(notDigitHeight))
			.isInstanceOf(IllegalArgumentException.class);
	}
}