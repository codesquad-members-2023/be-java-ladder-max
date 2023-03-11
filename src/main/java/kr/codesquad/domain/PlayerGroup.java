package kr.codesquad.domain;

import java.util.Arrays;

public class PlayerGroup {
    private final int MAX_NAME_LENGTH = 5;

    private final Player[] players;
    //private String[] playerNames;

    public PlayerGroup(String[] playerNames) {
        players = Arrays.stream(playerNames)
                .map(Player::new)
                .toArray(Player[]::new);
    }

    public int getPlayerCount() {

        return players.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Player player : players) {
            sb.append(String.format("%5s ", String.format("%-" + (((MAX_NAME_LENGTH - player.getName().length()) / 2) + player.getName().length()) + "s", player.getName())));
        }

        return sb.toString();
    }
}
