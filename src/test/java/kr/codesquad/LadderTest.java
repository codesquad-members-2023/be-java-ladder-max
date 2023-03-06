package kr.codesquad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 잘만들어 지는지 확인")
    void TestmakeLadder() {
        Ladder ladderForTest = new Ladder();
        ladderForTest.setPeopleNum(5);
        ladderForTest.setLadderHeight(5);

        ladderForTest.makeLadder();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++){
            for(int j =0;j<9;j++){
                sb.append(ladderForTest.ladder[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}