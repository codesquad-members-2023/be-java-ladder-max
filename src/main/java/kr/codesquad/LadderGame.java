package kr.codesquad;

import java.util.Scanner;

public class LadderGame {
    void run(){
        Ladder ladder;
        Input input = new Input(new Scanner(System.in));
        int numberOfPlayers;
        int ladderHeight;

        Output.printInputNumberOfPlayerQuestion();
        numberOfPlayers = input.inputNumberOfPlayers();
        Output.printInputLadderHeightQuestion();
        ladderHeight = input.inputLadderHeight();

        ladder = new Ladder(numberOfPlayers, ladderHeight);
        Output.printLadder(ladder.toString());
    }
}
