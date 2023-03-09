package kr.codesquad;

import java.util.List;

public class Validator {
    public void validatePlayers(List<String> players) {
        for (String player : players) {
            validatePlayer(player);
        }
    }

    private void validatePlayer(String player) {
        if (player.length() > 5) {
            throw new RuntimeException("이름이 5글자 이상이네요");
        }
    }
}
