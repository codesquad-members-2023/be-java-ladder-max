package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.Arrays;

public class Ladder {
    private Random random = new Random();
    private int width;
    private int height;
    private String[][] ladderBoard;
    private List<String> names;

    public void init(int inputerGetLadderNum, String inputerGetNames) {
        makeNames(inputerGetNames);
        widthIs();
        height = inputerGetLadderNum;
        makeLadder();
    }

    private void makeNames(String inputerGetNames) {
        String[] str = inputerGetNames.split(",");
        names = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            names.add(str[i]);
        }
    }

    private void widthIs() {
        width = (names.size() * 2) - 1;
    }

    private void makeLadder() {
        ladderBoard = new String[height][width];
        for (int i = 0; i < height; i++) {
            functionForMakeLadder1(i);
            functionForMakeLadder2(i);
        }
    }

    private void functionForMakeLadder1(int i) {
        for (int j = 0; j < width; j++) {
            ifSentenceInFunctionForMakeLadder1(i, j);
        }
    }

    private void ifSentenceInFunctionForMakeLadder1(int i, int j) {
        if (j % 2 == 0) {
            ladderBoard[i][j] = "|";
        }
    }
    private void functionForMakeLadder2(int i) {
        for (int j = 0; j < width; j++) {
            smallIfSentence1InFunctionForMakeLadder2(i, j);
            smallIfSentence2InFunctionForMakeLadder2(i, j);
            smallIfSentence3InFunctionForMakeLadder2(i, j);
        }
    }

    private void smallIfSentence1InFunctionForMakeLadder2(int i, int j) {
        if (j % 2 == 1 && ladderBoard[i][j - 1] == "     " && random.nextBoolean() == true) {
            ladderBoard[i][j] = "     ";
        }
    }

    private void smallIfSentence2InFunctionForMakeLadder2(int i, int j) {
        if (j % 2 == 1 && ladderBoard[i][j - 1] == "     " && random.nextBoolean() == false) {
            ladderBoard[i][j] = "-----";
        }
    }

    private void smallIfSentence3InFunctionForMakeLadder2(int i, int j) {
        if (j % 2 == 1 && ladderBoard[i][j - 2] == "-----" && random.nextBoolean() == false) {
            ladderBoard[i][j] = "-----";
        }
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < names.size(); i++) {
            sb.append(" ");
            sb.append(String.format("%5s", names.get(i)));
        }
        String str = sb.toString();
        System.out.println(str);

        for (int i = 0; i < height; i++) {
            System.out.print("    ");
            System.out.println(Arrays.toString(ladderBoard[i]));
        }
    }
}