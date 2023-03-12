package kr.codesquad.Model;

import kr.codesquad.Model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerList {
    List<Player> players = new ArrayList<>();

    public PlayerList(String players) {
        setPlayers(players);
    }

    private void setPlayers(String players){
        Arrays.stream(players.split(","))
                .forEach(p -> this.players.add(new Player(p)));
    }

    public int size(){
        return players.size();
    }

}
