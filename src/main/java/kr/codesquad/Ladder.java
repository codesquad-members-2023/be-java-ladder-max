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
        this.figureLadder = new String[height][countOfPerson+countOfPerson-1]; // 변수명이 printLadder가 올바른지? -> 수정 완
    }
    void ladderFeature() {
        for (int i = 0; i < height; i++) {
            verticalLadder(i);
            horizontalLadder(i);
        }
    }
//    public void makeLadder() {
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < countOfPerson*2 -1; j++) {
//                printLadder[i][j] = "|";
//                if (j % 2 != 0) {
//                    printLadder[i][j] = randomLadder();
//                }
//            }
//        }
//      for (String s[] : printLadder) {
//            String s1 = Arrays.stream(s).collect(Collectors.joining());
//            sb.append(s1).append("\n");
//        }
//    }

//    public StringBuilder stringLadder() {   -> toString으로 대체
//        for (String s[] : printLadder) {
//            String s1 = Arrays.stream(s).collect(Collectors.joining());
//            sb.append(s1).append("\n");
//        }
//        return sb;
//    }
    void verticalLadder(int row) {
        for (int i = 0; i < countOfPerson*2 -1; i+=2) {
            figureLadder[row][i] = "|";
        }
    }
    void horizontalLadder(int row) {
        for (int i = 1; i < countOfPerson*2 -1 ; i+=2) {
            figureLadder[row][i] = randomLadder();
        }
    }
    String randomLadder() {
        String[] ladderRandom = {" ", "-"};
        Random random = new Random();
        return ladderRandom[random.nextInt(2)];
    }

    @Override
    public String toString() {
        StringBuilder sbr = new StringBuilder();
        ladderFeature();
        for (int i = 0; i < height; i++) {
            String collect = Arrays.stream(figureLadder[i]).collect(Collectors.joining());
            sbr.append(collect).append("\n");
        }
        return sbr.toString();
    }
}
