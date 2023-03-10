package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Users;

public class OutputView {

    private OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printUsers(Users users) {
        System.out.printf(" %s\n", users);
    }
}
