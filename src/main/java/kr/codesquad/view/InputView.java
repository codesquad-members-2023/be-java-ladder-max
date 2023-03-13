package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    final String[] promptMessages = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
            "최대 사다리 높이는 몇 개인가요?"};

    public void ParticipantNamePrompt(){
        System.out.println(promptMessages[0]);
    }
    public void LadderHeightPrompt(){
        System.out.println(promptMessages[1]);
    }

    public String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
