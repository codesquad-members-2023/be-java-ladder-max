import kr.codesquad.domain.LadderRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {
    @DisplayName("사다리의 한 로우에서 라인이 있으면 이동한 인덱스 아니면 현재 인덱스 출력")
    @Test
    public void moveLineTest() {
        LadderRow ladderRow = new LadderRow(3);
        System.out.println(ladderRow);

        System.out.println("0에서 이동한 index : " + ladderRow.moveLine(0));
        System.out.println("1에서 이동한 index : " + ladderRow.moveLine(1));
        System.out.println("2에서 이동한 index : " + ladderRow.moveLine(2));
        System.out.println("3에서 이동한 index : " + ladderRow.moveLine(3));
    }

}
