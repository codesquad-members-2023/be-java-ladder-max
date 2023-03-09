package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputName() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        return br.readLine();
    }

    public int inputHeight() throws IOException {
        System.out.println("사다리 높이를 입력하세요.");
        return Integer.parseInt(br.readLine());
    }

    public void closeBr() throws IOException {
        br.close();
    }
}
