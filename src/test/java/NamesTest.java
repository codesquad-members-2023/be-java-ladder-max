import kr.codesquad.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NamesTest {
    @DisplayName("이름이 최대 5글자로 출력되는지 확인")
    @Test
    public void countOfNameLength() {
        Names names = new Names(new String[]{"poby", "honux", "crong", "jk"});
        String nameRow = names.makeNameRow();
        System.out.println(nameRow);

        // 5글자 + 공백1칸 = 6
        // 6 * 4 = 24
        assertThat(nameRow.length()).isEqualTo(24);
    }
}
