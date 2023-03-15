package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Players {
    private static final int OVER_LENGTH = 5;
    private static final int UNDER_LENGTH = 1;
    private final List<String> players;

    public Players(String names) {
        checkNamesSize(names);
        this.players = Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    private void checkNamesSize(String names) {
        String nameTokens[] = names.split(",");
        for (String name : nameTokens) {
            isGreaterThanFive(name);
        }
    }

    private void isGreaterThanFive(String name) {
        if (name.length() > OVER_LENGTH || name.length() < UNDER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 다시 입력하세요");
        }
    }

    public int getCountOfPerson() {
        return players.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        players.forEach(name -> sb.append(center(name)));
        return sb.toString();
    }
    // 이름을 가운데로 정렬하는 메서드
    public String center (String name) {
        if (name.length() == 5) {
            return String.format("%s ", name);
        }
        if (name.length() == 4) {
            return String.format(" %s ", name);
        }
        if (name.length() == 2) {
            return String.format("  %s  ", name);
        }
        int padding = (5 - name.length()) / 2;
        return String.format("%" + padding + "s%s%" + padding + "s ", "", name, "");
    }
}
