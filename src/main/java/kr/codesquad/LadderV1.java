package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderV1 implements Ladder {
    private final LadderPart[][] map;
    private final int width;
    private final int height;

    public LadderV1(int playerNumber, int height) {
        this.width = playerNumber * 2 - 1;
        this.height = height;
        this.map = new LadderPart[height][width];

        initMap();
    }

    private void initMap() {
        for (int y = 0; y < height; y++) {
            initLadderWidthLine(y);
        }
    }

    private void initLadderWidthLine(int y) {
        for (int x = 0; x < width; x++) {
            map[y][x] = LadderPart.from(x);
        }
    }

    @Override
    public List<String> createOutputLines() {
        return Arrays.stream(map)
                .map(LadderV1::toOutputLine)
                .collect(Collectors.toList());
    }

    private static String toOutputLine(LadderPart[] ladderWidthLine) {
        return Arrays.stream(ladderWidthLine)
                .map(LadderPart::getShape)
                .collect(Collectors.joining());
    }

}
