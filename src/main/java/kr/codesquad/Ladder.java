package kr.codesquad;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ladder {
    private final LadderPart[][] map;

    public Ladder(int player, int height) {
        map = new LadderPart[height][player * 2 - 1];
        initMap();
    }

    private void initMap() {
        for (int y = 0; y < map.length; y++) {
            initWidthLine(y);
        }
    }

    private void initWidthLine(int y) {
        for (int x = 0; x < map[0].length; x++) {
            map[y][x] = LadderPart.create(x);
        }
    }

    public String makeMapToString() {
        return Arrays.stream(map)
                .map(Ladder::makeLadderLineToString)
                .collect(Collectors.joining("\n"));
    }

    private static String makeLadderLineToString(LadderPart[] ladderWidthLine) {
        return Arrays.stream(ladderWidthLine)
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
