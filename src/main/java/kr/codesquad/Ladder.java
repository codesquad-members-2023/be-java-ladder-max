package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class Ladder {
    private final Random random = new Random();
    //    private int width;
    private int height;
    private List<List<String>> ladderBoard;
    private List<String> names;

    public void init(int inputerGetLadderNum, ArrayList inputerGetNameAndCheckNameLength) {
        makeNames(inputerGetNameAndCheckNameLength);
//        widthIs();
        height = inputerGetLadderNum;
        makeLadder();
    }

    private void makeNames(ArrayList inputerGetNameAndCheckNameLength) {
        names = inputerGetNameAndCheckNameLength;
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
    private void forInForInMakeLadder(int i) {
        boolean temp = random.nextBoolean();
        int x = 0;
        if (temp) {
            x = 1;
        }
        switchInForInForInMakeLadder(i, x);
        for (int j = 1; j < names.size() - 1; j++) {
            temp = random.nextBoolean();
            x = 0;
            ifInForInForInForInMakeLadder(temp, i, j, x);
        }
    }

    private void ifInForInForInForInMakeLadder(boolean temp, int i, int j, int x) {
        if (temp && ladderBoard.get(i).get(j - 1).equals("     ")) {
            x = 1;
        }
        reusedSwitchInForInForInMakeLadder(i, x);
    }

    private void switchInForInForInMakeLadder(int i, int x) {
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

    private void reusedSwitchInForInForInMakeLadder(int i, int x) {
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
        sb.append(" ");
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
