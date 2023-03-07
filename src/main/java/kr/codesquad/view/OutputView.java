package kr.codesquad.view;

import kr.codesquad.model.Ladder;

import java.util.List;

public class OutputView {

    public static void printInputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printInputMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printPeople(List<String> people) {
        System.out.println(people);
    }
}
