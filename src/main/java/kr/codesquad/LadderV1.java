package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderV1 implements Ladder {
    private final LadderPart[][] map;

    public LadderV1(int playerNumber, int height) {
        int width = playerNumber * 2 - 1;
        map = new LadderPart[height][width];
        initMap(height, width);
    }

    private void initMap(int height, int width) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = LadderPart.from(x);
            }
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
