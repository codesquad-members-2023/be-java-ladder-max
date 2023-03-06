package kr.codesquad;

import java.util.List;

public class LadderPrinter {

    void print(String drawnLadder) {
        System.out.println(drawnLadder);
    }

    public void print(List<String> requestNames, String drawnLadder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String requestName : requestNames) {
            stringBuilder.append(String.format("%6s",requestName));
        }
        System.out.println(stringBuilder);
        System.out.println(drawnLadder);
    }
}
