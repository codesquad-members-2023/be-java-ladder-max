package kr.codesquad;

import java.util.Scanner;

public class Input {
    int InputNumberOfPlayers () {
        return inputIntValue();
    }

    int InputLadderHeight(){
        return inputIntValue();
    }

    int inputIntValue(){
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}
