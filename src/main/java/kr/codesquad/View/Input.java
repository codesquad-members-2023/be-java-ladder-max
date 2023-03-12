package kr.codesquad.View;

import java.util.Scanner;

public class Input {
    Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public int inputNumberOfPlayers() {
        return sc.nextInt();
    }

    public int inputLadderHeight(){
        return sc.nextInt();
    }
}
