package kr.codesquad.domain;

public class Players {
    private String[] playerNames;

    public Players(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int getPlayerCount() {
        return playerNames.length;
    }
}
