package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @Nested
    @DisplayName("LadderRow의 짝수 index 위치에만 playerLine이 들어갈 수 있는지 테스트 한다.")
    class SetPlayerLineTest {
        private LadderRow ladderRow;
        int[] oddIndex;
        int[] evenIndex;

        @BeforeEach
        void initTest() {
            // 준비(Arrange)
            int columnSize = 5;
            oddIndex = new int[]{0, 2, 4};
            evenIndex = new int[]{1, 3, 5};
            ladderRow = new LadderRow(columnSize);
        }

        @Test
        @DisplayName("RadderRow의 짝수 index 위치에 set 하면 해당 위치에 ture값을 저장한다.")
        void setPlayerLineTestSuccess() {
            for(int index : oddIndex) {
                // 실행(Act)
                ladderRow.setPlayerLine(index); // set은 실행일까 준비일까?
                boolean result = ladderRow.isPlayerLine(index);

                // 단언(Assert)
                assertThat(result).isTrue();
            }
        }

        @Test
        @DisplayName("RadderRow의 홀수 index 위치에 set 하면 해당 위치는 false값이 유지된다.")
        void setPlayerLineTestFail() {
            for(int index : evenIndex) {
                // 실행(Act)
                ladderRow.setPlayerLine(index); // set은 실행일까 준비일까?
                boolean result = ladderRow.isPlayerLine(index);

                // 단언(Assert)
                assertThat(result).isFalse();
            }
        }
    }

}
