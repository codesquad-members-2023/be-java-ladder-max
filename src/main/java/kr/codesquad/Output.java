package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public void printWholeFigure(List<String> players, String ladderFigure) {
        String playersFigure = drawPlayers(players);
        System.out.println(playersFigure);
        System.out.println(ladderFigure);
    }

    private String drawPlayers(List<String> players) {
        StringBuilder sb = new StringBuilder();

        for (String player : players) {
            sb.append(String.format("%-6s", player));
        }
        return sb.toString();
    }
}
