package kr.codesquad;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    static int inputNumberOfPlayers() {
        return sc.nextInt();
    }

    static int inputLadderHeight(){
        return sc.nextInt();
    }
}
