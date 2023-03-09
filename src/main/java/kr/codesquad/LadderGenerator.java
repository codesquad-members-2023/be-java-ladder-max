package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public Ladder generate(List<String> playerNames, int height) {
        final List<List<LadderPart>> map = makeMap(playerNames.size(), height);

        return new PlayerNameLadder(map);
    }

    private List<List<LadderPart>> makeMap(int player, int height) {
        final List<List<LadderPart>> map = new ArrayList<>();
        int width = player * 2 - 1;

        for (int y = 0; y < height; y++) {
            map.add(createLadderLine(width));
        }

        return map;
    }

    private List<LadderPart> createLadderLine(int width) {
        final List<LadderPart> ladderLine = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            ladderLine.add(decideLadderPart(ladderLine, x));
        }

        return ladderLine;
    }

    private LadderPart decideLadderPart(List<LadderPart> ladderLine, int x) {
        if (isExistCrossBarOnLeft(ladderLine, x)) {
            return LadderPart.EMPTY;
        }

        return LadderPart.from(x);
    }

    private boolean isExistCrossBarOnLeft(List<LadderPart> ladderLine, int x) {
        return x > 2 && ladderLine.get(x - 2) == LadderPart.CROSSBAR;
    }
}
