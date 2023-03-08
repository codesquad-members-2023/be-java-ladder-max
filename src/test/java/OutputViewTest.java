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
        people.add("abcde");
        outputView.printPeople(people);
        assertThat(outputMessage.toString()).isEqualToIgnoringWhitespace("\n실행결과\n\n" + " abcde");
        // 의문점: 왜 isEqualToIgnoringWhitespace으로 공백을 제거해줘야 할까?
    }

}
