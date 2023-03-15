package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderRowTest {
    @DisplayName("LadderLine의 열 개수 체크하는 Test 코드 작성")
    @Test
    void ladderLineTest(){
        //given
        int number = 4;
        //4가 입력되었으므로 4*2 -1 = 7
        LadderRow ladderLine = new LadderRow(number);

        //when
        List<String> ladderLineTest = ladderLine.makeLadderColumn();

        //then
        assertThat(ladderLineTest.size()).isEqualTo(7);
    }

    @DisplayName("LadderLine의 Element를 일부로 틀리는 Test 코드 작성")
    @Test
    void ladderLineTest2() {
        //given
        int number = 3;
        LadderRow ladderRow = new LadderRow(number);

        //when
        List<String> ladderColumn = ladderRow.makeLadderColumn();

        //then
        assertThat(!ladderColumn.contains("|")).isFalse();
    }

}
