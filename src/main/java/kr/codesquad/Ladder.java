package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<List<LadderPart>> map = new ArrayList<>();

    public Ladder(int player, int height) {
        initMap(player, height);
    }

    private void initMap(int player, int height) {
        int width = player * 2 - 1;

        for (int y = 0; y < height; y++) {
            map.add(y, new ArrayList<>());
            initWidthLine(width, y);
        }
    }

    private void initWidthLine(int width, int y) {
        for (int x = 0; x < width; x++) {
            map.get(y).add(LadderPart.create(x));
        }
    }

    public List<String> makeMapToString() {
        return map.stream()
                .map(Ladder::makeLadderLineToString)
                .collect(Collectors.toList());
    }

    private static String makeLadderLineToString(List<LadderPart> ladderWidthLine) {
        return ladderWidthLine.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
