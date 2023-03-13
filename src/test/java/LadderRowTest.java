import kr.codesquad.domain.LadderRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderRowTest {
    @Test
    @DisplayName("사다리 로우의 한 위치에서 라인 유무에 따른 이동 위치 테스트")
    public void moveLineTest() {
        LadderRow ladderRow = new LadderRow(3);
        String ladderString = ladderRow.toString();
        System.out.println(ladderString);

        String[] arr = ladderString.split("\\|");
        String first = arr[1];
        String second = arr[2];
        String third = arr[3];

        // 0에서 이동하는 위치
        if(first.equals("-----")){
            assertThat(ladderRow.moveLine(0)).isEqualTo(1);
        } else {
            assertThat(ladderRow.moveLine(0)).isEqualTo(0);
        }

        // 1에서 이동하는 위치
        if(first.equals("-----")){
            assertThat(ladderRow.moveLine(1)).isEqualTo(0);
        } else {
            if(second.equals("-----")) {
                assertThat(ladderRow.moveLine(1)).isEqualTo(2);
            } else {
                assertThat(ladderRow.moveLine(1)).isEqualTo(1);
            }
        }

        // 2에서 이동하는 위치
        if(second.equals("-----")){
            assertThat(ladderRow.moveLine(2)).isEqualTo(1);
        } else {
            if(third.equals("-----")) {
                assertThat(ladderRow.moveLine(2)).isEqualTo(3);
            } else {
                assertThat(ladderRow.moveLine(2)).isEqualTo(2);
            }
        }

        // 3에서 이동하는 위치
        if(third.equals("-----")){
            assertThat(ladderRow.moveLine(3)).isEqualTo(2);
        } else {
            assertThat(ladderRow.moveLine(3)).isEqualTo(3);
        }
    }

}
