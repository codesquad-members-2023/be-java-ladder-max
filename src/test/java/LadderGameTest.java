import kr.codesquad.domain.LadderGame;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
    @Test
    @DisplayName("")
    @IgnoreForBinding
    void testStart(){

    }

    @Test
    @DisplayName("'춘식이'를 검색했을때 종료되는지 확인")
    void testExit(){
        String player = "pobi,honux,crong,jk";
        String resultList = "꽝,5000,꽝,3000";
        int row = 5;
        LadderGame ladderGame = new LadderGame();
        ladderGame.start(player,resultList,row);
        String result = ladderGame.searchResult("pobi");
        assertEquals("pobi : 5000",result);

    }
}
