package kr.codesquad.view;

import kr.codesquad.domain.LadderResult;
import kr.codesquad.domain.Result;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(Result result) {
        System.out.printf("\n실행 결과\n%s\n", result);
    }

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.printf(" %s\n\n", ladderResult.printLadderResult());
    }

    public static void printAllUserAndResult(LadderResult ladderResult) {
        System.out.printf("\n실행 결과\n%s\n", ladderResult.printAllUserAndResult());
    }

    public static void printExit() {
        System.out.println("\n프로그램을 종료합니다.");
    }
}
