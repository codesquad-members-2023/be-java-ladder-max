package kr.codesquad.domain.player;

import java.util.Arrays;

public class PlayerGroup {

    private final Player[] players;

    public PlayerGroup(String[] playerNames) {
        validatePlayerNamesLength(playerNames);
        players = Arrays.stream(playerNames)
                .map(Player::new)
                .toArray(Player[]::new);
    }

    private void validatePlayerNamesLength(String[] playerNames) {
        if(playerNames.length < 2) {
            throw new IllegalArgumentException("[ERROR] 최소 두 명 이상의 플레이어를 입력해 주세요.");
        }
    }

    public int getPlayerCount() {

        return players.length;
    }

    public String getName(int index) {
        if(index >= players.length) {
            return null;
        }
        return players[index].getName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Player player : players) {
            sb.append(player.getCenterAlignedName()).append(" ");
        }

        return sb.toString();
    }
}
