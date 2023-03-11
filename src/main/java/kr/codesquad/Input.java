package kr.codesquad;

import java.util.Scanner;

public class Input {
    Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    int inputNumberOfPlayers() {
        return sc.nextInt();
    }

    int inputLadderHeight(){
        return sc.nextInt();
    }
}
