package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public Ladder generate(int playerNumber, int height) {
        if (isInValidNumber(playerNumber) || isInValidNumber(height)) {
            throw new IllegalArgumentException("사다리를 생성할 수 없습니다.");
        }

        final List<List<LadderPart>> map = makeMap(playerNumber, height);

        return new PlayerNameLadder(map);
    }

    private boolean isInValidNumber(int number) {
        return number < 1;
    }

    private List<List<LadderPart>> makeMap(int playerNumber, int height) {
        final List<List<LadderPart>> map = new ArrayList<>();
        int width = playerNumber * 2 - 1;

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
