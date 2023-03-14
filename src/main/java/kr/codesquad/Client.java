package kr.codesquad;

import kr.codesquad.domain.Input;
import kr.codesquad.domain.LadderGame;

public class Client {
    public void startGame(){
        Input input = new Input();
        LadderGame ladderGame = new LadderGame();
        ladderGame.start(input.getPlayers(),input.getRow());
    }
}
