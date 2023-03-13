package ladder;

import kr.codesquad.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    Line line = new Line(4);
    List<Boolean> list = line.getPoint();
    @Test
    @DisplayName("라인출력 성공 테스트")
    void drawCheckSuccessTest(){
        for(int i = 0; i<list.size(); i ++) {
            list.set(i,false);
        }
        list.set(0,true);
        list.set(2,true);
        String str = line.toString();
        assertThat(str).isEqualTo(" |-----|     |-----|     |");
    }

    @Test
    @DisplayName("라인출력 실패 테스트")
    void drawCheckFailTest(){
        Line line = new Line(4);
        List<Boolean> list = line.getPoint();
        for(int i = 0; i<list.size(); i ++) {
            list.set(i,false);
        }
        String str = line.toString();
        assertThat(str).isEqualTo(" |     |     |     |     |");


    }
}
