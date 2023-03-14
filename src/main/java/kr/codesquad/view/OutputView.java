package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Line;

import java.util.List;

public class OutputView {

    public void printLadderStatus(Ladder ladder) {
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

    public void printPeople(List<String> people) {
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

    public void printOne(List<String> finals, String input) {
        System.out.println(finals
                .stream().map(o -> o.split( " : "))
                .filter(o -> o[0].equals(input))
                .findFirst()
                .orElse(new String[] {"", "없는 이름이 로직을 탐."})[1]);
    }

    public void endGame() {
        System.out.println();
        System.out.print("게임을 종료합니다.");
        System.exit(0);
    }


}
