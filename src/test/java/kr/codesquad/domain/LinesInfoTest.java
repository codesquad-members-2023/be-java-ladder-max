package kr.codesquad.domain;

import static kr.codesquad.domain.LineDelimiterType.FAIL_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.PEOPLE_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.SUCCESS_DELIMITER;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LinesInfoTest {



    @DisplayName("LinesInfo가 ladderheight만큼 linesInfo 생성")
    @ParameterizedTest
    @CsvSource({"10, 10", "20, 30"})
    void create(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = LinesInfo.create(namesSize, ladderHeight);
        Assertions.assertThat(linesInfo.size()).isEqualTo(ladderHeight);
    }

    @DisplayName("LineInfo 를 추가하고 저장한다.")
    @ParameterizedTest
    @CsvSource({"10, 10", "20, 30"})
    void add(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = LinesInfo.create(namesSize, ladderHeight);
        LineInfo lineInfo = new LineInfo(new ArrayList<>());
        Assertions.assertThat(linesInfo.size()).isEqualTo(ladderHeight);
        linesInfo.add(lineInfo);
        Assertions.assertThat(linesInfo.size()).isEqualTo(ladderHeight + 1);
    }

    @DisplayName("사다리 그리기")
    @ParameterizedTest
    @CsvSource({"5, 5", "30, 40"})
    void draw(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = LinesInfo.create(namesSize, ladderHeight);
        Assertions.assertThat(linesInfo.draw())
                .contains(PEOPLE_DELIMITER.getValue(), SUCCESS_DELIMITER.getValue(), FAIL_DELIMITER.getValue())
                .matches("( {3}\\|((" + SUCCESS_DELIMITER.getValue() + "|" + FAIL_DELIMITER.getValue() + ")\\|){" + (
                        namesSize - 1) + "}\\n){" + ladderHeight + "}");
    }


    @DisplayName("계산결과를 저장한다.")
    @Test
    void calculatorAndSaveResult() {
        LadderResultRepository ladderResultRepository = new LadderResultRepository();
        String crong = "crong";
        String honux = "honux";
        String jk = "jk";
        String pobi = "pobi";
        List<String> names = List.of(crong, honux, jk, pobi);

        String empty = "꽝";
        String one = "1";
        String three = "3";
        String two = "2";
        List<String> resultInfo = List.of(empty, one, two, three);
        LinesInfo linesInfo = LinesInfo.create(4, 5);
        linesInfo.calculatorAndSaveResult(ladderResultRepository, names, resultInfo);

        Assertions.assertThat(ladderResultRepository.containsName(crong)).isTrue();
        Assertions.assertThat(ladderResultRepository.containsName(honux)).isTrue();
        Assertions.assertThat(ladderResultRepository.containsName(jk)).isTrue();
        Assertions.assertThat(ladderResultRepository.containsName(pobi)).isTrue();

        Assertions.assertThat(ladderResultRepository.searchAll())
                .contains(empty, one, three, two);
    }
}
