package kr.codesquad.view;

import java.util.List;

public class Outputview {

    public void printLadder(List<String> ladderColumn){

    }
    public static void printLadder(String[][] ladder) {
        for (int row = 0; row < ladder.length; row++) {
            for (int column = 0; column < ladder[row].length; column++) {
                System.out.print(ladder[row][column]);
            }
            System.out.println();
        }
    }


}
