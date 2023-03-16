package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kr.codesquad.ladder.exception.InvalidContainOfNamesException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {

    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    @ParameterizedTest
    @DisplayName("사다리 게임의 최소 인원수보다 작은 입력이 주어질때 예외가 발생하는지 테스트")
    @ValueSource(strings = {"pobi", "pobi,", "pobi, "})
    public void newNames(String input) {
        //given
        String[] nameArray = input.split(DELIMITER.pattern());
        List<Name> nameList = createNameList(nameArray);
        //when
        Throwable actual = Assertions.catchThrowable(() -> new Names(nameList));
        //then
        Assertions.assertThat(actual).isInstanceOf(InvalidCountOfPeopleException.class);
    }

    private List<Name> createNameList(String[] nameArray) {
        List<Name> nameList = new ArrayList<>();
        for (String name : nameArray) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    @Test
    @DisplayName("인원들에 포함되지 않은 다른 이름을 탐색시 예외가 발생하는지 테스트")
    public void findIndexByName_fail() {
        //given
        String[] nameArray = {"pobi", "hounx", "crong", "jk"};
        List<Name> nameList = createNameList(nameArray);
        Names names = new Names(nameList);
        Name target = new Name("jaja");
        //when
        Throwable actual = Assertions.catchThrowable(() -> names.findIndexByName(target));
        //then
        Assertions.assertThat(actual).isInstanceOf(InvalidContainOfNamesException.class);
    }

}
