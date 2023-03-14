package kr.codesquad;

import kr.codesquad.domain.InputLadder;
import kr.codesquad.domain.LadderGame;

public class Client {
    public void startGame(){
        InputLadder input = new InputLadder();
        LadderGame ladderGame = new LadderGame();
        ladderGame.start(input.inputPlayers(),input.inputRow());
    }
}
