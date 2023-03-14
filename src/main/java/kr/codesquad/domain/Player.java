package kr.codesquad.domain;

public class Player {
    private final PlayerName name;
    private final int position;

    public Player(PlayerName name, int position) {
        this.name = new PlayerName(name);
        this.position = position;
    }
}
