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
}
