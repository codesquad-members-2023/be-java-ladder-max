package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<String> playersList;

    public Players(List playersList) {
        this.playersList = playersList;
    }

    public int getCountOfPlayers() {
        return playersList.size();
    }

    String getPlayer(int i){
        return playersList.get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : playersList) {
            sb.append(String.format(" %1$-5s", name));
        }
        sb.append("\n");
        return sb.toString();
    }
}