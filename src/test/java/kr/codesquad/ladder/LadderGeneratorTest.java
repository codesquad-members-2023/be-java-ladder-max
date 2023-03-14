package kr.codesquad.ladder;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.Point;
import kr.codesquad.ladder.domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LadderGeneratorTest {

    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BAR = "|";

    private int m;
    private LadderGenerator ladderGenerator;

    @Test
    @DisplayName("사람 2명과 사다리 높이2가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generateLadderPart_testcase1() {
        //given
        String input = "pobi,hounx";
        Names names = new Names(input, 2);
        m = 2;
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, false);
        ladderGenerator = new LadderGenerator(m, 1);
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

    @Test
    @DisplayName("사다리의 한 라인에 브리지가 2개 이상 연속적으로 나오지 않는지 테스트")
    public void generateLadderPart_testcase3() {
        //given
        String input = "pobi,hounx,crong";
        Names names = new Names(input, 2);
        m = 1;
        //mocking
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextBoolean()).thenReturn(true, true);
        ladderGenerator = new LadderGenerator(m, 1);
        //when
        Ladder actual = ladderGenerator.createLines(names.size(), mockRandom);
        //then
        Line line1 =
            new Line(new Points(new ArrayList<>(
                List.of(Point.ofBar(), Point.ofBridge(), Point.ofBar(), Point.ofEmpty(),
                    Point.ofBar()))));
        Ladder expected = new Ladder(new ArrayList<>(List.of(line1)));

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
