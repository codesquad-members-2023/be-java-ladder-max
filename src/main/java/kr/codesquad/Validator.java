package kr.codesquad;

import java.util.List;

public class Validator {
    private final static int PLAYER_MAX_LENGTH = 5;
    public void validatePlayers(List<String> players) {
        for (String player : players) {
            validatePlayer(player);
        }
    }

    private void validatePlayer(String player) {
        if (player.length() > PLAYER_MAX_LENGTH) {
            throw new RuntimeException("이름이 5글자 이상이네요");
        }
    }
}
