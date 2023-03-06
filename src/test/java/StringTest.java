import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void 문자열_길이_구하기() throws Exception {
        String name = "하이";
        assertThat(name.length()).isEqualTo(2);
    }

    @Test
    public void 문자열_더하기() throws Exception {
        String name = "문자열";
        String plus = "안녕!";
        assertThat(name+plus).isEqualTo("문자열안녕!");
    }

    @Test
    public void 문자_단위로_출력() throws Exception {
        String name = "문자열";
        char[] arr = name.toCharArray();
        for(char ch : arr){
            System.out.println(ch);
        }
    }

    @Test
    public void 문자열_뒤집기() throws Exception {
        String name = "문자열";
        char [] arr = name.toCharArray();
        String result = "";
        for(int i=arr.length-1; i>=0; i--){
            result += arr[i];
        }

        assertThat(result).isEqualTo("열자문");
    }
}
