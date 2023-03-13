package kr.codesquad.controller.dto;

public class LadderInputDto {
    private final int playerNumber;
    private final int height;

    public LadderInputDto(int playerNumber, int height) {
        this.playerNumber = playerNumber;
        this.height = height;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getHeight() {
        return height;
    }
}
