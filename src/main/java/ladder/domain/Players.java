package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String[] names) {
        checkMinPlayer(names.length);
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    private void checkMinPlayer(int players) {
        final int MIN = 2;
        if (players < MIN) {
            throw new IllegalArgumentException("2명 이상 참여해야 시작할 수 있습니다.");
        }
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public String makeNameLabels(int size) {
        StringBuilder builder = new StringBuilder();
        for (Player player : players) {
            builder.append(player.makeNameLabel(size));
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }
}
