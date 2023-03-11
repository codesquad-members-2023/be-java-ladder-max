package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    public String input(BufferedReader br, int index) throws IOException {
        String[] answer = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"
                ,"최대 사다리 높이는 몇 개인가요?"};
        System.out.println(answer[index]);
        return br.readLine();
    }

    public int inputLadder(String answer) {
        return Integer.parseInt(answer);
    }
}
