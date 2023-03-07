package kr.codesquad;

import java.util.Random;

public class Ladder {
    private String[][] laddder;

    Ladder(int n, int m) {
        this.laddder = new String[m][2 * n - 1];

    }

    void makeBasicLadder() {
        for (int i = 0; i < laddder.length; i++) {
            for (int j = 0; j < laddder[i].length; j++) {
                if (j % 2 == 0) {
                    this.laddder[i][j] = "|";
                } else this.laddder[i][j] = " ";
            }
        }
    }

    void showFinalLadder() {

        for (int i = 0; i < laddder.length; i++) {
            for (int j = 0; j < laddder[i].length; j++) {
                System.out.print(laddder[i][j]);
            }
            System.out.println();
        }
    }

    void makeRandomLadderLine() {
        /*
         아무 위치에 사다리를 생성하는 것이 아니라,
         2차원 배열에서 열의 인덱스가 홀수 일때
         임의로 사다리를 그릴 수 있다.

         사다리가 최대 들어갈 수 있는 회수는
         m * (n-1) 이다.
         */

        // if -> True라면


        for (int i = 0; i < laddder.length; i++) {
            for (int j = 0; j < laddder[i].length; j++) {
                Random random = new Random();
                boolean randomBoolean = random.nextBoolean();
                if (randomBoolean && j % 2 == 1) {
                    laddder[i][j] = "-";
                }
            }
        }
    }

    void printLadder() {
        System.out.println(laddder);
    }

}
