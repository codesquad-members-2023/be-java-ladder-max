package kr.codesquad;

import java.util.List;

public class LadderGenerator {
    public static Ladder of(List<String> playerNames, int height) {
        return new LadderV2(playerNames, height);
    }

    public static Ladder of(int playerNumber, int height) {
        return new LadderV1(playerNumber, height);
    }
}
