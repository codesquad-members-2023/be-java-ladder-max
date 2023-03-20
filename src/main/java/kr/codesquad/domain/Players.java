package kr.codesquad.domain;

import java.util.List;

public class Players {
    private final List<String> playersList;

    public Players(List playersList) {
        this.playersList = playersList;
    }

    public int getCountOfPlayers() {
        return playersList.size();
    }

    public String getPlayer(int i){
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