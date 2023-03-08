package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderV2 implements Ladder {
    private final List<List<LadderPart>> map = new ArrayList<>();
    private final List<String> playerNames;

    public LadderV2(List<String> playerNames, int height) {
        this.playerNames = playerNames;
        initMap(playerNames.size(), height);
    }

    private void initMap(int player, int height) {
        int width = player * 2 - 1;

        for (int y = 0; y < height; y++) {
            map.add(createLadderLine(width));
        }
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

    @Override
    public List<String> createOutputLines() {
        final List<String> outputLines = new ArrayList<>();
        outputLines.add(makePlayerNamesFormat());
        outputLines.addAll(makeLadderShape());

        return outputLines;
    }

    private List<String> makeLadderShape() {
        return map.stream()
                .map(LadderV2::toOutputLine)
                .collect(Collectors.toList());
    }

    private static String toOutputLine(List<LadderPart> ladderWidthLine) {
        return ladderWidthLine.stream()
                .map(LadderPart::getShape)
                .collect(Collectors.joining());
    }

    private String makePlayerNamesFormat() {
        return playerNames.stream()
                .map(playerName -> String.format("%-6s", playerName))
                .collect(Collectors.joining());
    }
}
