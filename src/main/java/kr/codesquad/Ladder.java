package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class Ladder {
    private final Random random = new Random();
    private int width;
    private int height;
    private List<List<String>> ladderBoard;
    private List<String> names;

    public void init(int inputerGetLadderNum, String inputerGetNames) {
        makeNames(inputerGetNames);
//        widthIs();
        height = inputerGetLadderNum;
        makeLadder();
    }

    private void makeNames(String inputerGetNames) {
        names = new ArrayList<>();
        for (int i = 0; i < inputerGetNames.split(",").length; i++) {
            names.add(inputerGetNames.split(",")[i]);
        }
    }

//    private void widthIs() {
//        width = (names.size() * 2 - 1);
//    }

    private void makeLadder() {
        ladderBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(i).add("|");
            forInForInMakeLadder(i);
        }
    }

    void forInForInMakeLadder(int i) {
        for (int j = 0; j < names.size()-1; j++) {
            boolean temp = random.nextBoolean();
            int x = 0;
            if (temp) {
                x = 1;
            }
            switchInForInForInMakeLadder(i, x);
        }
    }

    void switchInForInForInMakeLadder(int i, int x) {
        switch (x) {
            case 1:
                ladderBoard.get(i).add("-----");
                ladderBoard.get(i).add("|");
                break;
            case 0:
                ladderBoard.get(i).add("     ");
                ladderBoard.get(i).add("|");
                break;
        }
    }

    public void printResult() {
        printNames();
        printLadder();

    }
    private void printNames() {
        StringBuilder sb = new StringBuilder();
//        sb.append(" ");
        for (int i = 0; i < names.size(); i++) {
            sb.append(" ");
            sb.append(String.format("%5s", names.get(i)));
        }
        System.out.println(sb);
    }
    private void printLadder() {
        for (int i = 0; i < height; i++) {
            System.out.print("    ");
            forLoopInPrintLadder(i);
            System.out.print("\r\n");
        }
    }

    private void forLoopInPrintLadder(int i) {
        for (String j : ladderBoard.get(i)) {
            System.out.print(j);
        }
    }


}
