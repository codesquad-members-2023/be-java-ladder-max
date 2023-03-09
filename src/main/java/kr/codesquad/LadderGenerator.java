package kr.codesquad;

import java.util.List;

public class LadderGenerator {
    public Ladder create(List<String> playerNames, int height) {
        return new PlayerNameLadder(playerNames, height);
    }
}
