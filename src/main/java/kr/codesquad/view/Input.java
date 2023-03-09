package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputName() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        return validationName(br.readLine());
    }

    public int inputHeight() throws IOException {
        System.out.println("사다리 높이를 입력하세요.");
        return validationHeight(Integer.parseInt(br.readLine()));
    }

    public void closeBr() throws IOException {
        br.close();
    }

    public String validationName(String inputData) {
        if(!inputData.matches(".+,.+")){
            throw new RuntimeException("참여할 사람은 2명 이상 이어야 합니다.");
        }
        return inputData;
    }

    public int validationHeight(int height) {
        if(height < 0){
            throw new RuntimeException("사다리의 높이는 1이상 이어야 합니다.");
        }
        return height;
    }
}
