package kr.codesquad;

import java.util.List;

public class LadderGenerator {
    public static Ladder of(List<String> playerNames, int height) {
        return new LadderV2(playerNames, height);
    }
}
