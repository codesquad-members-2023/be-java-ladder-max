package kr.codesquad.Controller;

import kr.codesquad.Model.Ladder;
import kr.codesquad.Model.PlayerList;
import kr.codesquad.View.Input;
import kr.codesquad.View.Output;

import java.util.Scanner;

public class LadderGame {
    public void run(){
        Ladder ladder;
        Input input = new Input(new Scanner(System.in));
        String allPlayerString;
        PlayerList playerList;
        int ladderHeight;

        Output.printInputPlayerQuestion();
        allPlayerString = input.inputPlayers();
        playerList = new PlayerList(allPlayerString);
        Output.printInputLadderHeightQuestion();
        ladderHeight = input.inputLadderHeight();

        ladder = new Ladder(numberOfPlayers, ladderHeight);
        Output.printLadder(ladder.toString());
    }
}
