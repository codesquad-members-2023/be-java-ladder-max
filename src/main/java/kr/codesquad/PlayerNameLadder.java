package kr.codesquad;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNameLadder implements Ladder {
    private final List<List<LadderPart>> map;

    public PlayerNameLadder(List<List<LadderPart>> map) {
        this.map = map;
    }

    @Override
    public List<String> createOutputLines() {
//        outputLines.add(makePlayerNamesFormat());
        return map.stream()
                .map(PlayerNameLadder::toOutputLine)
                .collect(Collectors.toList());
    }

    private static String toOutputLine(List<LadderPart> ladderWidthLine) {
        return ladderWidthLine.stream()
                .map(LadderPart::getShape)
                .collect(Collectors.joining());
    }

//    private String makePlayerNamesFormat() {
//        return playerNames.stream()
//                .map(playerName -> String.format("%-6s", playerName))
//                .collect(Collectors.joining());
//    }
}
