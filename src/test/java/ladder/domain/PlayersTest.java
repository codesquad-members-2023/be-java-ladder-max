package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

	@DisplayName("사람이름으로 구성된 문자열이 주어질 때 players 객체를 생성하면 객체 생성에 성공한다")
	@Test
	void creatablePlayersTest() {
		//given
		String names = "jk,pie,papa";

		//when & then
		assertThatCode(() -> new Players(names))
			.doesNotThrowAnyException();
	}
	@DisplayName("5글자가 넘는 사람이 주어질때 Players 객체를 생성하면 예외를 던진다")
	@Test
	void overLengthTest() {
		// given
		String names = "brunii,crong,pie";

		//when & then
		assertThatThrownBy(() -> new Players(names))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 잘못된 입력입니다. 다시 입력하세요");
	}

}