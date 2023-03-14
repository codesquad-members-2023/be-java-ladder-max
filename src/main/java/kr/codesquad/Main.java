package kr.codesquad;

import kr.codesquad.domain.Input;
import kr.codesquad.domain.LadderGame;

public class Main {
    Input input = new Input();
    LadderGame ladderGame = new LadderGame(input.getPlayers(),input.getRow());
}
