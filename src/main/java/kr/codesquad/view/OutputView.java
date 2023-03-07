package kr.codesquad.view;

import kr.codesquad.model.Ladder;

public class OutputView {

    public static void printInputN() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void printInputMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
