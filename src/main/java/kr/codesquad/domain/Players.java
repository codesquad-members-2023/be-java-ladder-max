package kr.codesquad.domain;

import java.util.List;

public class Players {
    private final PlayerName name;

    public Players(String name) {
        this.name = new PlayerName(name);
    }
}
