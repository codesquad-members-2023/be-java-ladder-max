package kr.codesquad;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    @DisplayName("사람 2명과 사다리 높이2가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase1(){
        //given
        int n = 2;
        int m = 2;
        Ladder ladder = new Ladder(n, m);
        //when
        String[][] actual = ladder.generate();
        //then
        String[][] expected = {{"|","-","|"},
                               {"|"," ","|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사람 3명과 사다리 높이5가 주어질 때 랜덤한 사다리 생성하는지 테스트")
    public void generate_testcase2(){
        //given
        int n = 3;
        int m = 5;
        Ladder ladder = new Ladder(n, m);
        //when
        String[][] actual = ladder.generate();
        //then
        String[][] expected = {{"|","-","|"," ","|"},
                               {"|"," ","|","-","|"},
                               {"|","-","|","-","|"},
                               {"|"," ","|","-","|"},
                               {"|","-","|"," ","|"}};
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}