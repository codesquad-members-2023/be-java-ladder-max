package kr.codesquad;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private StringBuilder sb = new StringBuilder();
    int countOfPerson;
    int height;
    String figureLadder[][];
    // n과 m 받아서 for문 만들기
    // n은 참여할 사람 , m은 사다리의 높이
    public Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
        this.figureLadder = new String[height][countOfPerson+countOfPerson-1];
    }
        private void ladderFeature() {
        for (int i = 0; i < height; i++) {
            verticalLadder(i);
            horizontalLadder(i);
        }
    }
    private void verticalLadder(int row) {     // 짝수 column 에 | 넣기
        for (int i = 0; i < countOfPerson*2 -1; i+=2) {
            figureLadder[row][i] = "|";
        }
    }
    private void horizontalLadder(int row) {  // 홀수 column 에 random 으로 - 넣기
        for (int i = 1; i < countOfPerson*2 -1 ; i+=2) {
            figureLadder[row][i] = randomLadder();
        }
    }
    private String randomLadder() {
        String[] ladderRandom = {" ", "-"};
        Random random = new Random();
        return ladderRandom[random.nextInt(2)];
    }

    @Override
    public String toString() {    // 한줄로 만들어진 column 을 모아서 StringBuilder 로 사다리의 길이 만큼 합쳐 만들기
        StringBuilder sbr = new StringBuilder();
        ladderFeature();
        for (int i = 0; i < height; i++) {
            String collect = Arrays.stream(figureLadder[i]).collect(Collectors.joining());
            sbr.append(collect).append("\n");
        }
        return sbr.toString();
    }
}
