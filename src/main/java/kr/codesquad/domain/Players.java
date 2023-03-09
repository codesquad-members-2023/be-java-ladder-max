package kr.codesquad.domain;

public class Players {
    private final int MAX_NAME_LENGTH = 5;

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
            sb.append(String.format("%5s ", String.format("%-" + (((MAX_NAME_LENGTH - name.length()) / 2) + name.length()) + "s", name)));
        }

        return sb.toString();
    }
}
