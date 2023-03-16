package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.exception.InvalidCountOfLadderResultException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DestinationsTest {

    @Test
    @DisplayName("객체 생성시 입력한 실행결과의 개수가 인원수와 맞지 않아 예외가 발생하는지 테스트")
    public void newDestinations() {
        //given
        int countOfPeople = 4;
        String[] inputs = {"꽝", "5000", "꽝"};
        List<Destination> dstList = createDestinationList(inputs);
        //when
        Throwable actual = Assertions.catchThrowable(
            () -> new Destinations(dstList, countOfPeople));
        //then
        Assertions.assertThat(actual).isInstanceOf(InvalidCountOfLadderResultException.class);
    }

    private List<Destination> createDestinationList(String[] inputs) {
        List<Destination> dstList = new ArrayList<>();
        for (String input : inputs) {
            dstList.add(new Destination(input));
        }
        return dstList;
    }

}
