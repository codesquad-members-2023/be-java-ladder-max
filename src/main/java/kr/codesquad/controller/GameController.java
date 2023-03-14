package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class GameController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Ladder ladder = inputView.createLadder();
        outputView.printLadderStatus(ladder);
        printLadderResult(inputView, outputView, ladder);
    }

    private void printLadderResult(InputView inputView, OutputView outputView, Ladder ladder) {
        while (true) {
            findLadderResult(inputView.insertResultName(), outputView, ladder);
        }
    }

    private void findLadderResult(String input, OutputView outputView, Ladder ladder) {
        if(input.equals("춘식이")) {
            outputView.endGame();
        }
        printAllOrOne(input, outputView, ladder);
    }

    private void printAllOrOne(String input, OutputView outputView, Ladder ladder) {
        System.out.println();
        System.out.println("실행 결과");
        if(input.equals("all")) {
            ladder.getFinalPositions().stream().forEach(System.out::println);
            return;
        }
        if(!findName(input, outputView, ladder)) {
            System.out.println();
            System.out.println("잘못된 사람을 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private boolean findName(String input, OutputView outputView, Ladder ladder) {
        if (ladder.getPeople().contains(input)) { // 현재 사람들 리스트에 있는 경우
            outputView.printOne(ladder.getFinalPositions(), input);
            return true;
        }
        return false;
    }
}
