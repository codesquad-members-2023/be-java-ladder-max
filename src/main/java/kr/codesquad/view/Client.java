package kr.codesquad.view;

import kr.codesquad.domain.LadderGame;


public class Client {
    public void startGame(){
        InputLadder input = new InputLadder();
        LadderGame ladderGame = new LadderGame();
        ladderGame.start(input.inputPlayers(),input.inputResult(),input.inputRow());
        while (true){
            String id = input.inputSearch();
            try {
                ladderGame.searchResult(id);
            } catch (IllegalArgumentException e){
                System.out.println("게임을 종료합니다.");
            }
        }
    }
}
