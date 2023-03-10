package kr.codesquad;

import java.util.Scanner;

public class Input {
    int inputNumberOfPlayers() {
        return inputIntValue();
    }

    static int inputLadderHeight(){
        return inputIntValue();
    }

    private static int inputIntValue(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
