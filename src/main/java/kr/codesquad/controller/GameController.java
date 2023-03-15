package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class GameController {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(); // 멤버변수로 빼는 게 좋나..?
        List<String> people = inputView.insertNames();
        int peopleLen = people.size();
        Ladder ladder = new Ladder(people, inputView.insertResults(peopleLen), inputView.insertHeight());
        outputView.printLadderStatus(ladder);
        printLadderResult(inputView, outputView, ladder);
    }

    private void printLadderResult(InputView inputView, OutputView outputView, Ladder ladder) {
        String input = inputView.insertResultName();
        while (!input.equals("춘식이")) {
            printAllOrPersonResult(input, outputView, ladder);
            input = inputView.insertResultName();
        }
        outputView.endGame();
    }

    private void printAllOrPersonResult(String input, OutputView outputView, Ladder ladder) {
        System.out.println("\n실행 결과");
        if(input.equals("all")) {
            outputView.printAllResults(ladder.getFinalPositions());
            return;
        }
        if(!containsPerson(input, ladder)) {
            outputView.printNoNameError();
            return;
        }
        outputView.printPersonResult(ladder.getFinalPositions(), input);
    }

    private boolean containsPerson(String input, Ladder ladder) {
        if (ladder.getPeople().contains(input)) { // 현재 사람들 리스트에 있는 경우
            return true;
        }
        return false;
    }
}
