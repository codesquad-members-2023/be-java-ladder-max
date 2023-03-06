package kr.codesquad.view;

public class OutputView {

    public void printLadder(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] == null? " " : ladder[i][j]);
            }
            System.out.println();
        }
    }
}
