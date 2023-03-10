import kr.codesquad.domain.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TypeTest {
    @Test
    @DisplayName("결과 타입 분류 테스트")
    void find_test() {
        assertThat(Type.find("all")).isEqualTo(Type.ALL);
        assertThat(Type.find("춘식이")).isEqualTo(Type.END);
        assertThat(Type.find("")).isEqualTo(null);
    }
}
