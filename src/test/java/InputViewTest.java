import kr.codesquad.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }
    @Test
    void 유효한_이름인지_테스트() {
        List<String> names = new ArrayList<>();
        names.add("abcde");
        assertThat(inputView.isValidNames(names)).isTrue();
        names.add("abcdef");
        assertThat(inputView.isValidNames(names)).isFalse();
    }
}
