import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static kr.codesquad.util.Validation.*;

public class ValidationTest {
    @Test
    @DisplayName("이름 다섯 글자 제한 테스트")
    void isAnyOverFive_test() {
        List<String> names = new ArrayList<>();
        names.add("abcde");
        assertThat(isAnyOverFive(names)).isFalse();
        names.add("abcdef");
        assertThat(isAnyOverFive(names)).isTrue();
    }

    @Test
    @DisplayName("유효한 참가자들을 등록했는지 테스트")
    void checkValidName_test() {
        List<String> names = new ArrayList<>();
        names.add("abc");
        assertThat(checkValidName(names)).isTrue();
        names.add("abc"); // 중복 이름
        assertThat(checkValidName(names)).isFalse();
        names.clear();
        names.add("춘식이"); // 종료 이름
        assertThat(checkValidName(names)).isFalse();
        names.clear(); // 빈 문자열 입력
        names.add("");
        assertThat(checkValidName(names)).isFalse();
    }

    @Test
    @DisplayName("유효한 숫자가 들어왔는지 테스트")
    void checkValidNum_test() {
        String input = ""; // 빈 문자열
        assertThat(checkValidNumber(input)).isFalse();
        input = "-1"; // 음수
        assertThat(checkValidNumber(input)).isFalse();
        input = "abc"; // 숫자가 아닌 문자
        assertThat(checkValidNumber(input)).isFalse();
        input = "1241212312421521512413123131132"; // 인트 범위 초과
        assertThat(checkValidNumber(input)).isFalse();
        input = "3";
        assertThat(checkValidNumber(input)).isTrue();
    }

    @Test
    @DisplayName("유효한 실행 결과를 등록했는지 테스트")
    void checkValidResults_test() {
        List<String> results = new ArrayList<>();
        results.add(""); // 빈 문자열 입력시
        assertThat(checkValidResults(results, 1)).isFalse();
        results.clear();
        assertThat(checkValidResults(results, 1)).isFalse(); // 결과와 참여한 사람들의 수가 다를 때
    }
}
