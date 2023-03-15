package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LadderTest {
    @DisplayName("Ladder Class의 makeLadder 실행 시, 해당 크기가 ladderHeight과 동일한지 확인하는 테스트 코드")
    @Test
    void LadderTest1(){
        //given
        int numberOfPeople = 4;
        int ladderHeight = 5;


        //when
        Ladder ladder = new Ladder();
        List<LadderRow> ladderRows = ladder.makeLadder(numberOfPeople, ladderHeight);

        //then
        Assertions.assertThat(ladderRows.size()).isEqualTo(ladderHeight );
    }

}
