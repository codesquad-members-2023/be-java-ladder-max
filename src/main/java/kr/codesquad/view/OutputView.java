package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderResult;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.Results;
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

    public static void printResults(Results results) {
        System.out.printf("%s\n\n", results);
    }

    public static void printResult(Result result) {
        System.out.printf("\n실행 결과\n%s\n", result);
    }

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.printf("\n실행 결과\n%s\n", ladderResult);
    }

    public static void printExit() {
        System.out.println("\n프로그램을 종료합니다.");
    }
}
