package kr.codesquad;

import java.util.Scanner;

public class Input {
    int inputNumberOfPlayers() {
        return inputIntValue();
    }

    int inputLadderHeight(){
        return inputIntValue();
    }

    private int inputIntValue(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
