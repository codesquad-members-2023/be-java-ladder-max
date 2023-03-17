package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final int PLAYER_MAX_LENGTH = 5;
    private final Scanner sc = new Scanner(System.in);

    public List<String> inputValidatedPlayers() {
        String[] players = null;

        try {
            players = inputPlayers();
            validatePlayersLength(players);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            return inputValidatedPlayers();
        }
        return Arrays.asList(players);
    }

    private String[] inputPlayers() {
        System.out.println("참가자 명부를 주시오");
        String[] splitPlayers = this.sc.nextLine().split(",");

        return splitPlayers;
    }

    private void validatePlayersLength(String[] players) {
        Arrays.stream(players)
                .forEach(s -> {
                    if (s.length() > PLAYER_MAX_LENGTH) {
                        throw new RuntimeException("참가자 이름이 너무 길잖소. 최대 글자수는 " + PLAYER_MAX_LENGTH + "이오.");
                    }
                });
    }

    public int inputHeight() {
        System.out.println("얼마나 길게 만들길 원하시오?");
        String height = sc.nextLine();

        return Integer.parseInt(height);
    }

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