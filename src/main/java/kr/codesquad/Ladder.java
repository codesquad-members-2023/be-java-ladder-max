package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class Ladder {
    private final Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> names;

    public void init(ArrayList<String> returnSeting) {
        names = returnSeting;
    }

    public void makeLadder(int height) {
        ladderBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(i).add("|");
            forInForInMakeLadder(i);
        }
    }

    private void forInForInMakeLadder(int i) {
        boolean tempBoolean = random.nextBoolean();
        int x = 0;
        if (tempBoolean) {
            x = 1;
        }
        switchAndForLoopInForLoopInForLoopInMakeLadder(tempBoolean, i, x);
    }

    private void switchAndForLoopInForLoopInForLoopInMakeLadder(boolean bool, int i, int x) {
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
        for (int j = 1; j < names.size() - 1; j++) {
            bool = random.nextBoolean();
            x = 0;
            ifStatementInForInForInForInMakeLadder(bool, i, j, x);
        }
    }

    private void ifStatementInForInForInForInMakeLadder(boolean boolen, int i, int j, int x) {
        if (boolen && ladderBoard.get(i).get(j - 1).equals("     ")) {
            x = 1;
        }
        reusedSwitchInForInForInMakeLadder(i, x);
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
        for (int i = 0; i < ladderBoard.size(); i++) {
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
