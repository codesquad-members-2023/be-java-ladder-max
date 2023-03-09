import kr.codesquad.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("이름들 출력 테스트")
    void printPeople_test() {
        List<String> people = new ArrayList<>();
        // pobi,honux,crong,jk
        people.add("pobi");
        people.add("honux");
        people.add("crong");
        people.add("jk");
        outputView.printPeople(people);
        assertThat(outputMessage.toString()).isEqualTo("\r\n실행결과\r\n\r\n" + "  pobi  honux crong   jk    \r\n");
    }

}
