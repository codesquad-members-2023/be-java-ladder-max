package kr.codesquad.view;

import java.io.IOException;

public class Output {

    public static void printMessageNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printMessageLadderNumber() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadder(String result) {
        System.out.println(result);
    }

    public static void printErrorMessage(IOException e) {
        System.out.println(e.getMessage());
    }
}
