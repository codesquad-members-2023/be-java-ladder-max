package kr.codesquad.domain;

public class Players {
    private String[] playerNames;

    public Players(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int getPlayerCount() {
        return playerNames.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String name : playerNames) {
            sb.append(String.format("%-5s ", name));
        }

        return sb.toString();
    }
}
