import kr.codesquad.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {
    @Test
    @DisplayName("사다리게임의 결과가 제대로 저장되고 출력되는지 확인")
    void testGetResult(){
        List<String> list = new ArrayList<>();
        list.add("pobi");
        list.add("honux");
        list.add("crong");
        list.add("jk");
        int[] result = {3,0,1,0,0,0,2};

        Players players = new Players(list,"꽝,5000,꽝,3000",result);
        String ans1 = players.searchResult("pobi");
        String ans2 = players.searchResult("honux");
        String ans3 = players.searchResult("crong");
        String ans4 = players.searchResult("jk");
        assertEquals("pobi : 3000",ans1);
        assertEquals("honux : 5000",ans2);
        assertEquals("crong : 꽝",ans3);
        assertEquals("jk : 꽝",ans4);

    }
}
