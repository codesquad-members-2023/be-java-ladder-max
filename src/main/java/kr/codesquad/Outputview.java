package kr.codesquad;

public class Outputview {
    public static void printLadder(String[][] ladder) {
        for (int row = 0; row < ladder.length; row++) {
            for (int column = 0; column < ladder[row].length; column++) {
                System.out.print(ladder[row][column]);
            }
            System.out.println();
        }
    }


}
