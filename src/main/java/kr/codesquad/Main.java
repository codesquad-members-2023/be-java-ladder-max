package kr.codesquad;

import java.io.IOException;
import kr.codesquad.ladder.LadderGame;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.RandomBooleansGenerator;
import kr.codesquad.ladder.view.InputView;

public class Main {
    public static void main(String[] args) throws IOException {
        LadderGame ladderGame = new LadderGame(new InputView(), new RandomBooleansGenerator(), new Ladder());
        ladderGame.start();

    }
}
