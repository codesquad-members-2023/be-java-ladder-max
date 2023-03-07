package kr.codesquad.view;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.domain.Player;

public class OutputView {

    public static void printLadder(List<Player> players, List<List<String>> ladder) {
        System.out.println("\n사다리 결과: \n");
        String result = ladder.stream()
                .map(oneLine -> String.join("", oneLine))
                .collect(Collectors.joining("\n"));
        printPlayers(players);
        System.out.println(result);
    }

    private static void printPlayers(List<Player> players) {
        String oneLine = players.stream()
                .map(player -> String.format("%-6s", player))
                .collect(Collectors.joining());
        System.out.println(oneLine);
    }
}
