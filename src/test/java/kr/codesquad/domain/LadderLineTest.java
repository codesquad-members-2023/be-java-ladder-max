package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 라인 테스트")
class LadderLineTest {

	@DisplayName("현재 라인에서 올바른 위치의 다음 라인으로 가는지 검증한다.")
	@Test
	void givenMockLadderLine_whenRide_thenSuccess() {
		// given
		LadderLine ladderLine = new LadderLine(List.of(true, false, false));

		// when
		int rideToRight = ladderLine.ride(0);
		int rideToLeft = ladderLine.ride(1);
		int rideToStraight = ladderLine.ride(3);

		// then
		assertAll(
			() -> assertThat(rideToRight).isEqualTo(1),
			() -> assertThat(rideToLeft).isEqualTo(0),
			() -> assertThat(rideToStraight).isEqualTo(3)
		);
	}
}