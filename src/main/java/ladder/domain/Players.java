package ladder.domain;

import java.util.*;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String[] names) {
        checkMinPlayer(names.length);
        checkDuplicatedName(names);
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

    private void checkDuplicatedName(String[] names) {
        Set<String> checkedNames = new HashSet<>(Arrays.asList(names));
        if (checkedNames.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
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
