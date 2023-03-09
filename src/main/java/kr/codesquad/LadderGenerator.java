package kr.codesquad;

import java.util.List;

public class LadderGenerator {
    public static Ladder of(List<String> playerNames, int height) {
        return new PlayerNameLadder(playerNames, height);
    }

    public static Ladder of(int playerNumber, int height) {
        return new PlayerNumberLadder(playerNumber, height);
    }
}
