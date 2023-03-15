package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import static kr.codesquad.util.ValidationPlayerName.MAX_LENGTH;

public class Ladder {

    public List<String> generateLadder(int numOfPlayer, int columnLength) {
        int rowLength = numOfPlayer + (numOfPlayer - 1);
        LadderLine ladderLine = new LadderLine();
        List<String> ladderList = new ArrayList<>();
        for(int i = 0; i < columnLength; i++) {
            ladderList.add(ladderLine.drawEachLine(rowLength));
        }
        return ladderList;
    }


    public String format(List<String> ladderList) {
        StringBuffer ladderSb = new StringBuffer();
        for(String row : ladderList) {
            ladderSb.append(" ".repeat((MAX_LENGTH + 1) / 2));
            ladderSb.append(row);
            ladderSb.append("\n");
        }
        return ladderSb.toString();
    }
}

