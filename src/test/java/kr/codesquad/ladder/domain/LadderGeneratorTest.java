package kr.codesquad.ladder.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kr.codesquad.ladder.exception.InvalidNumberOfMinimumLadderHeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    private int m;
    private LadderGenerator ladderGenerator;

    @Test
    @DisplayName("사람 2명과 사다리 높이2가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generateLadderPart_testcase1() {
        //given
        String[] nameArray = {"pobi", "honux"};
        Names names = new Names(createNameList(nameArray));
        m = 2;
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false);
        ladderGenerator = new LadderGenerator(m);
        //when
        Ladder actual = ladderGenerator.createLines(names.size(), mockRandom);
        //then
        Line line1 = new Line(
            new Points(new ArrayList<>(List.of(Point.ofBar(), Point.ofBridge(), Point.ofBar()))));
        Line line2 = new Line(
            new Points(new ArrayList<>(List.of(Point.ofBar(), Point.ofEmpty(), Point.ofBar()))));
        Ladder expected = new Ladder(new ArrayList<>(List.of(line1, line2)));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private List<Name> createNameList(String[] nameArray) {
        List<Name> nameList = new ArrayList<>();
        for (String name : nameArray) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    @Test
    @DisplayName("사다리의 한 라인에 브리지가 2개 이상 연속적으로 나오지 않는지 테스트")
    public void generateLadderPart_testcase3() {
        //given
        String[] nameArray = {"pobi", "honux", "crong"};
        Names names = new Names(createNameList(nameArray));
        m = 1;
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, true);
        ladderGenerator = new LadderGenerator(m);
        //when
        Ladder actual = ladderGenerator.createLines(names.size(), mockRandom);
        //then
        Line line1 = new Line(new Points(new ArrayList<>(
            List.of(Point.ofBar(), Point.ofBridge(), Point.ofBar(), Point.ofEmpty(),
                Point.ofBar()))));
        Ladder expected = new Ladder(new ArrayList<>(List.of(line1)));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("객체 생성시 최소 사다리 높이보다 적은 사다리 높이 입력시 예외가 발생하는지 테스트")
    public void newLadderGenerator() {
        //given
        int maximumLadderHeight = -1;
        //when
        Throwable actual =
            Assertions.catchThrowable(() -> new LadderGenerator(maximumLadderHeight));
        //then
        Assertions.assertThat(actual)
            .isInstanceOf(InvalidNumberOfMinimumLadderHeightException.class);
    }

}
