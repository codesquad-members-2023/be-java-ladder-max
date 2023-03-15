package kr.codesquad.domain;

import kr.codesquad.domain.ladder.LadderRow;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @Test
    @DisplayName("LadderRow 인스턴스 생성시 LadderRow의 Bridge는 연속으로 존재할 수 없다")
    void testNewLadderRow() {
        // LadderRow의 생성자 매개변수는 LadderRow List의 크기를 의미한다.
        // 테스트 하게에 충분한 정수값을 넣어주면 된다. (최소 2 이상이어야 테스트가 유효하다.)
        int ladderRowSize = 100;
        LadderRow ladderRow = new LadderRow(ladderRowSize);

        SoftAssertions softAssertions = new SoftAssertions();
        for(int i = 0; i < ladderRowSize - 1; i++) {
            if(ladderRow.isBridge(i)) {
                softAssertions.assertThat(ladderRow.isBridge(i)).isTrue().isNotEqualTo(ladderRow.isBridge(i + 1));
            }
        }
        softAssertions.assertAll();
    }

}
