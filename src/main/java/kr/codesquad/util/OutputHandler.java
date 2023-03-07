package kr.codesquad.util;

import kr.codesquad.Ladder;

public class OutputHandler {

    final String[] promptMessages = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
            "최대 사다리 높이는 몇 개인가요?"};

    void outputParticipantNamePrompt(){
        System.out.println(promptMessages[0]);
    }
    void outputLadderHeightPrompt(){
        System.out.println(promptMessages[1]);
    }

    void printLadder(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        char[][] tempLadder = ladder.getLadder();
        for (char[] row : tempLadder) {
            appendToSb(sb, row);
        }
        System.out.println(sb);
    }

    private static void appendToSb(StringBuilder sb, char[] tempLadder) {
        sb.append(tempLadder).append("\n");
    }
}
