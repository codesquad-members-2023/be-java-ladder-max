package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private static final int PLAYER_MAX_LENGTH = 5;
    private static final String POLE = "|";
    private static final String RUNG = "-".repeat(5);
    private static final String BLANK = " ".repeat(5);

    public void printPlayers(List<String> players) {
        StringBuilder sb = new StringBuilder();

        for (String player : players) {
            sb.append(String.format("%-6s", player));
        }
        System.out.println(sb);
    }

    public List<String> lineToString(List<List<Boolean>> lineInformation) {
        List<String> shape = new ArrayList<>();

        for (List l : lineInformation) {
            shape.add(encapsulateLine(l));
        }
        return shape;
    }
    private String encapsulateLine(List<Boolean> line) {
        StringBuilder sb = new StringBuilder();

        sb.append(POLE);
        for (boolean bool : line) {
            if (bool) {
                sb.append(RUNG);
                sb.append(POLE);
                continue;
            }
            sb.append(BLANK);
            sb.append(POLE);
        }
        return sb.toString();
    }
}
