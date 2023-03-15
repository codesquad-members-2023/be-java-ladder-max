package kr.codesquad.domain;

import kr.codesquad.strategy.RandomLinkStrategy;

import java.util.List;

import static kr.codesquad.domain.Direction.LEFT;

public class Line {
//    private static final String MAX_NAME_LENGTH_ERROR = "플레이어의 이름은 5글자 이내로 입력해주세요.";
//    private static final String MIN_NUM_OF_PLAYER_ERROR = "참여할 플레이어를 2명 이상 입력해주세요.";
//    private static final int MAX_PLAYER_NAME_LENGTH = 5;
//    private static final int MIN_NUM_OF_PLAYER = 2;
//    private final int lengthOfPlayerName;
//    private final int countOfPlayers;

    private final int size; // 라인의 길이
    private final List<Direction> directions;   // 라인의 이동 방향

    public Line(int size) {
        this.size = size;
    }

    private void link(RandomLinkStrategy strategy) {
        directions.addAll(strategy);    // 결정된 라인의 이동 방향 추가
    }

    private void move() {
        int currentIndex;   // 이동 결과 반환
    }

    private boolean isLinked(final Direction direction) {
        return direction.equals(LEFT);
    }

    //    public Line(int lengthOfPlayerName, int countOfPlayers) {
//        this.lengthOfPlayerName = lengthOfPlayerName;
//        this.countOfPlayers = countOfPlayers;
//    }
//
//    public Line(List<Point> points) {
//        this.points = points;
//    }
//
//    private void validatePlayerNameLength() {
//        if (MAX_PLAYER_NAME_LENGTH < lengthOfPlayerName) {
//            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR);
//        }
//    }
//
//    private void validateMinimumPlayers() {
//        if (MIN_NUM_OF_PLAYER > countOfPlayers) {
//            throw new IllegalArgumentException(MIN_NUM_OF_PLAYER_ERROR);
//        }
//    }
}
