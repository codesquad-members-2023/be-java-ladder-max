package kr.codesquad.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<String, String> results; // String,String은 뭐가 뭔지 알기가 어렵다

    private LadderResult(Map<String, String> results) {
        this.results = results;
    }

    public String getResult(String playerName) {
        return results.get(playerName);
    }

    public String getAllResults() {
        final StringBuilder builder = new StringBuilder();

        for (var result : results.entrySet()) {
            builder.append(result.getKey())
                    .append(" : ")
                    .append(result.getValue())
                    .append("\n");
        }

        return builder.toString();
    }

    public static LadderResult of(List<String> playerNames, List<String> goals, List<Point> points) {
        Map<String, String> results = new HashMap<>();
        for (Point point : points) {
            final String playerName = playerNames.get(point.getStartLadderNumber());
            final String goal = goals.get(point.getFinalLadderNumber());

            results.put(playerName, goal);
        }

        return new LadderResult(results);
    }
}
