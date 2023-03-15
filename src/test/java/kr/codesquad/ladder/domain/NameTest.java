package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @DisplayName("사라디 게임에 참가하는 사람들의 이름의 길이가 형식에 맞지 않아 예외가 발생하는지 테스트")
    @ValueSource(strings = {"poibjoawie", "", " ", "@#$@#", "12312"})
    public void newName(String input) {
        //given

        //when
        Throwable actual = Assertions.catchThrowable(() -> new Name(input));
        //then
        Assertions.assertThat(actual).isInstanceOf(InvalidNameFormatOfPeopleException.class);
    }
}
