package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputName() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        String nameInputData = br.readLine();

        return nameInputData;
    }

    public int inputHeight() throws IOException {
        System.out.println("최대 사다리 높이는??");
        int height = Integer.parseInt(br.readLine());

        System.out.println();
        br.close();

        return height;
    }
}
