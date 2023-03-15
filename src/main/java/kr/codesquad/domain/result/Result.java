package kr.codesquad.domain.result;

public class Result {
    private String playerName;
    private String destinationName;

    public Result(String playerName, String destinationName) {
        this.playerName = playerName;
        this.destinationName = destinationName;
    }

    public boolean isPlayerName(String playerName) {
        return this.playerName.equals(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDestinationName() {
        return destinationName;
    }

}
