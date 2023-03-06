package kr.codesquad.util;

import kr.codesquad.Ladder;

public class OutputHandler {
    void outPut(String str) {
        System.out.println(str);
    }

    void printLadder(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        char[][] tempLadder = ladder.getLadder();
        for(int i=0;i<ladder.getLadderHeight();i++){
            for(int j =0;j<ladder.getPeopleNum()* 2 - 1;j++){
                sb.append(tempLadder[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
