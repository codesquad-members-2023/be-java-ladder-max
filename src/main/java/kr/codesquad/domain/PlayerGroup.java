package kr.codesquad.domain;

import java.util.Arrays;

public class PlayerGroup {

    private final Player[] players;

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
            sb.append(player.getName()).append(" ");
        }

        return sb.toString();
    }
}
