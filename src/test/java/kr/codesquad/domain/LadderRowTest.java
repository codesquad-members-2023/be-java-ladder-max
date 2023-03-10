package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

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
            int columnSize = 7;
            oddIndex = new int[]{0, 2, 4, 6};
            evenIndex = new int[]{1, 3, 5};
            ladderRow = new LadderRow(columnSize);
        }

        @Test
        @DisplayName("RadderRow의 짝수 index 위치에 set 하면 해당 위치에 ture값을 저장한다.")
        void setPlayerLineTestSuccess() {
            for (int index : oddIndex) {
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
            for (int index : evenIndex) {
                // 실행(Act)
                ladderRow.setPlayerLine(index); // set은 실행일까 준비일까?
                boolean result = ladderRow.isPlayerLine(index);

                // 단언(Assert)
                assertThat(result).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("LadderRow의 홀수 index 위치, 이전 bridge 영역에 bridge가 없을 경우에만 bridge가 삽입 가능한지 테스트 한다.")
    class SetBridgeTest {
        private LadderRow ladderRow;
        int[] oddIndex;
        int[] evenIndex;

        @BeforeEach
        void initTest() {
            // 준비(Arrange)
            int columnSize = 7;
            oddIndex = new int[]{0, 2, 4, 6};
            evenIndex = new int[]{1, 3, 5};
            ladderRow = new LadderRow(columnSize);
        }

        @Test
        @DisplayName("LadderRow의 홀수 index 위치, 이전 bridge 영역에 bridge가 없을 경우에만 해당 위치에 true값을 저장한다")
        void setBridgeTestSuccess() {
            // 준비
            Queue<Boolean> results = new ArrayDeque<>(evenIndex.length);

            // 실행(Act)
            for (int index : evenIndex) {
                ladderRow.setBridge(index);
                results.add(ladderRow.isBridge(index));
            }

            // 단언(Assert)
            // [설명]
            // - 실행 단계에서 LadderRow의 List<boolean>에 홀수 index마다 setBridge()를 해줬다
            // - 만약 List의 길이가 7이라면, List<boolean> 는 [false, true, false, false, false, true, false] 가 나오게 된다
            // - List<boolean>를 도식화 하면 다음과 같다 : [ | - |   | - | ]
            // - 짝수 index 위치는 playerLine 영역(`|`)이라서 false 상태여야 한다
            // - 홀 수 위치 중 이전 bridge 영역(`-` or ` `)에 bridge가 있는 경우 bridge가 겹치면 안 되기 때문에 false 상태여야 한다
            boolean turn = true;
            for(int index : evenIndex) {
                if(turn) {
                    assertThat(results.poll()).isTrue();
                } else {
                    assertThat(results.poll()).isFalse();
                }
                turn = !turn;
            }

        }

        @Test
        @DisplayName("RadderRow의 짝수 index 위치에 set 하면 해당 위치는 false값이 유지된다.")
        void setBridgeTestFail() {
            for (int index : oddIndex) {
                // 실행(Act)
                ladderRow.setBridge(index); // set은 실행일까 준비일까?
                boolean result = ladderRow.isBridge(index);

                // 단언(Assert)
                assertThat(result).isFalse();
            }
        }
    }

}
