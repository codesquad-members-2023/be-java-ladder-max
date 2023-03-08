package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("참가자 리스트 도메인 테스트")
class ParticipantsTest {

	@DisplayName("올바른 참가자 리스트가 주어지면 생성에 성공한다.")
	@Test
	void givenRightParticipants_whenCreateParticipants_thenSuccessCreate() {
		// given
		String rightParticipants = "jk,honux,crong,pobi,chloe";

		// when & then
		assertThatCode(() -> new Participants(rightParticipants))
			.doesNotThrowAnyException();
	}

	@DisplayName("이름의 길이가 5가 넘는 참가자가 주어지면 예외를 던진다.")
	@Test
	void givenOverLengthParticipants_whenCreateParticipants_thenThrowsException() {
		// given
		String overLengthParticipants = "jk,honux,crong,pobi,chloe,unknown";

		// when & then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> new Participants(overLengthParticipants));

		assertThat(exception.getMessage()).contains("unknown");
	}
}