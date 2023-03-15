package kr.codesquad.domain;

public class Players {
    private final static String SEPARATOR = ",";
    private final PlayerName name;

    public Players(String[] name) {
        this.name = new PlayerName(name);
    }
}
