package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static kr.codesquad.util.ValidationPlayerName.MAX_LENGTH;

public class LadderLine {
    private static final String verticalLine = "|";
    private static final String straightLine = "-".repeat(MAX_LENGTH);
    private static final String BlankLine = " ".repeat(MAX_LENGTH);

    public String drawEachLine(int rowLength) {
        List<String> eachLineList = new ArrayList<>();
        eachLineList.add(verticalLine);
        for(int i = 1; i < rowLength; i+=2) {
            eachLineList.add(selectHorizonLine(eachLineList, i));
            eachLineList.add(verticalLine);
        }
        return eachLineStr(eachLineList);
    }

    public String eachLineStr(List<String> eachLineList) {
        StringBuffer lineSb = new StringBuffer();
        for(String line : eachLineList) {
            lineSb.append(line);
        }
        return lineSb.toString();
    }

    private String selectHorizonLine(List<String> eachLineList, int currentRow) {
        boolean lineFlag = isLineCreated() && !isBridgeConnected(eachLineList, currentRow);
        return lineFlag ? straightLine : BlankLine;
    }

    private boolean isBridgeConnected(List<String> eachLineList, int currentRow) {
        if(currentRow == 1) return false;
        return eachLineList.get(currentRow - 2).equals(straightLine);
    }

    private boolean isLineCreated() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
