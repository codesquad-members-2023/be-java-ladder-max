package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String MIN_PLAYERS_ERROR = "최소 2명 이상의 참여자가 필요합니다.";
    private static final String MAX_NAME_LENGTH_ERROR = "플레이어의 이름은 5글자 이하로 입력해주세요.";
    private static final int MIN_NUM_OF_PLAYERS = 2;
    public static final int MAX_NAME_LENGTH = 6;
    private List<String> names;
    public final int longestNameSize;  // 입력된 플레이어 이름 중 가장 긴 이름의 길이


    public Players(final String players) {
        this.names = Arrays.stream(players.split(","))
                .map(String::new)
                .collect(Collectors.toList());
        validateCount(names);
        this.longestNameSize = validateName(names);
    }

    private void validateCount(List<String> names) {
        if (names == null || names.size() < MIN_NUM_OF_PLAYERS) {
            throw new IllegalArgumentException(MIN_PLAYERS_ERROR);
        }
    }

    private int validateName(List<String> names) {
        int longestNameSize = 0;
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR);
            }
            longestNameSize = Math.max(longestNameSize, name.length());
        }
        return longestNameSize;
    }

    public int getSize() {
        return names.size();
    }

    public List<String> getNames() {
        return names;
    }
}