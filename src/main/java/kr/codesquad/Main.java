package kr.codesquad;

import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

public class Main {
    public static void main(String[] args) {
        final LadderGame ladderGame = new LadderGame(new Screen());

        ladderGame.run();
    }
}