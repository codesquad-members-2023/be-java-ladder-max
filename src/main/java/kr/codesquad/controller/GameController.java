package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Line;
import kr.codesquad.view.InputView;

import java.util.List;

public class GameController {

    public void run() {
        InputView inputView = new InputView();
        List<String> people = inputView.insertNames();
        int peopleLen = people.size();
        Ladder ladder = new Ladder(people, inputView.insertResults(peopleLen), inputView.insertHeight());
        printLadderResult(inputView, ladder);
    }

    private void printLadderResult(InputView inputView, Ladder ladder) {
        printLadderStatus(ladder);
        String input = inputView.insertResultName();
        while (!input.equals("춘식이")) {
            printAllOrPersonResult(input, ladder);
            input = inputView.insertResultName();
        }
        System.out.print("\r\n게임을 종료합니다.");
    }

    private void printAllOrPersonResult(String input, Ladder ladder) {
        System.out.println("\r\n실행 결과");
        if(input.equals("all")) {
            ladder.getFinalPositions().stream().forEach(System.out::println);
            return;
        }
        if(!containsPerson(input, ladder)) {
            System.out.println("\r\n잘못된 사람을 입력하셨습니다. 다시 입력해주세요.");
            return;
        }
        printPersonResult(ladder.getFinalPositions(), input);
    }

    private void printPersonResult(List<String> finalPositions, String input) {
        System.out.println(finalPositions
                .stream().map(o -> o.split( " : "))
                .filter(o -> o[0].equals(input))
                .findFirst()
                .orElse(new String[] {"", "없는 이름이 로직을 탐."})[1]);
    }

    private boolean containsPerson(String input, Ladder ladder) {
        if (ladder.getPeople().contains(input)) { // 현재 사람들 리스트에 있는 경우
            return true;
        }
        return false;
    }

    private void printLadderStatus(Ladder ladder) {
        List<String> people = ladder.getPeople();
        List<Line> lines = ladder.getLines();
        List<String> results = ladder.getResults();
        printPeople(people);
        for(Line line : lines) {
            System.out.print("    |");
            System.out.println(line);
        }
        printList(results);
    }

    private void printPeople(List<String> people) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        printList(people);
    }

    private void printList(List<String> list) {
        System.out.println(" " + list.stream()
                .map(o -> " ".repeat((6 - o.length()) / 2) + o
                        + " ".repeat((8 - o.length()) / 2))
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o)
                        , StringBuilder::append));
    }
}
