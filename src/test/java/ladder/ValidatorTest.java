package ladder;

import kr.codesquad.ladder.view.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("이름 길이 성공 테스트")
    void nameValidateSuccessTest(){
        String[] name = {"light","crong","jk","honux"};
        assertThat(validator.nameValidate(name)).isEqualTo(true);
    }

    @Test
    @DisplayName("이름 길이 실패 테스트")
    void nameValidateFailTest(){
        String[] name = {"light","crong","jk","honuxfadads"};
        assertThat(validator.nameValidate(name)).isEqualTo(false);
    }
}
