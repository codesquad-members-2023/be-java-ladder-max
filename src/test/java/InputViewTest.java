import kr.codesquad.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }
    @Test
    @DisplayName("이름 다섯 글자 제한 테스트")
    void isValidNames_test() {
        List<String> names = new ArrayList<>();
        names.add("abcde");
        assertThat(inputView.isValidNames(names)).isTrue();
        names.add("abcdef");
        assertThat(inputView.isValidNames(names)).isFalse();
    }
}
