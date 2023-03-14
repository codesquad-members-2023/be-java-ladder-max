import kr.codesquad.domain.Elements;
import kr.codesquad.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @DisplayName("이름이 최대 5글자로 출력되는지 확인")
    @Test
    public void countOfNameLength() {
        Names names = new Names("poby,honux,crong,jk");
        String nameRow = names.toString();
        System.out.println(nameRow);

        // 5글자 + 공백1칸 = 6
        // 6 * 4 + 1(\n) = 25
        // poby  honux crong    jk  \n
        assertThat(nameRow.length()).isEqualTo(25);
        assertThat(nameRow).isEqualTo("poby  honux crong   jk  \n");
    }
}
