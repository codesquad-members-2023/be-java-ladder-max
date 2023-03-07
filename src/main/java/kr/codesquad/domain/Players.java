package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.message.ErrorMessage;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        validateUniqueName(players);
        this.players = players;
    }

    private void validateUniqueName(List<Player> players) {
        if (players.size() != players.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_PLAYER_NAME.toString());
        }
    }

    public int number() {
        return players.size();
    }

    public List<String> names() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.toList());
    }
}
