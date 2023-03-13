package kr.codesquad.View;

import java.util.Scanner;

public class Input {
    Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public String inputPlayers(){
        return sc.nextLine();
    }

    public int inputNumberOfPlayers() {
        return sc.nextInt();
    }

    public int inputLadderHeight(){
        return sc.nextInt();
    }
}
