import kr.codesquad.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @Test
    void 이름들_출력_테스트() {
        List<String> people = new ArrayList<>();
        // pobi,honux,crong,jk
        people.add("pobi");
        people.add("honux");
        people.add("crong");
        people.add("jk");
        outputView.printPeople(people);
        assertThat(outputMessage.toString()).isEqualToIgnoringNewLines("실행결과" + "  pobi  honux crong   jk    ");
        // 의문점: 왜 isEqualToIgnoringNewLines로 개행문자를 제거해줘야 할까? 스트림 문제?
    }

}
