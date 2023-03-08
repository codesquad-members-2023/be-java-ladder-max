package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;

public class OutputHandler {

    final String[] promptMessages = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
            "최대 사다리 높이는 몇 개인가요?"};

    public void outputParticipantNamePrompt(){
        System.out.println(promptMessages[0]);
    }
    public void outputLadderHeightPrompt(){
        System.out.println(promptMessages[1]);
    }

    public void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> tempLadder = ladder.getLadder();
        System.out.println("\n결과출력\n");
        for(String str: tempLadder){
            sb.append(str);
        }
        System.out.println(sb);
    }
}
