package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderLineTest {
    @DisplayName("LadderLine의 열 개수 체크하는 Test 코드 작성")
    @Test
    void ladderLineTest(){
        //given
        int number = 4;
        //4가 입력되었으므로 4*2 -1 = 7
        LadderRow ladderLine = new LadderRow();

        //when
        List<String> ladderLineTest = ladderLine.makeLadderRow(number);

        //then
        org.assertj.core.api.Assertions.assertThat(ladderLineTest.size()).isEqualTo(7);
    }

}
