package kr.codesquad;

public class Output {
    public void printLadder(boolean[][] rungs) {
        for(boolean[] row : rungs) {
            System.out.print("|");
            for(boolean rung : row) {
                if(rung) {
                    System.out.print(" - ");;
                } else {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }
}
