package kr.codesquad.study;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class Calculator {

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] nums = text.split("[,:]");
        return Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
    }
}

public class StringAddCalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null값을 입력하는 경우 0을 반환하는지 테스트")
    public void calculate_testcase1() {
        //given
        String input1 = "";
        String input2 = null;
        //when
        int actual1 = calculator.calculate(input1);
        int actual2 = calculator.calculate(input2);
        //then
        Assertions.assertThat(actual1).isEqualTo(0);
        Assertions.assertThat(actual2).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력하는 경우 해당 숫자를 반환하는지 테스트")
    public void calculate_testcase2() {
        //given
        String input = "1";
        //when
        int actual = calculator.calculate(input);
        //then
        Assertions.assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환하는지 테스트")
    public void calculate_testcase3() {
        //given
        String input = "1,2";
        //when
        int actual = calculator.calculate(input);
        //then
        Assertions.assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용하여 합을 반환하는 테스트")
    public void calculate_testcase4() {
        //given
        String input = "1,2:3";
        //when
        int actual = calculator.calculate(input);
        //then
        Assertions.assertThat(actual).isEqualTo(6);
    }


}
