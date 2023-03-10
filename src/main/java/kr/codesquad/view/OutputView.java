package kr.codesquad.view;

import kr.codesquad.domain.Line;

import java.util.List;

public class OutputView {

    public void printAll(List<String> people, List<Line> ladders, List<String> results) {
        printPeople(people);
        for(Line line : ladders) {
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

    public void printResults() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void insertError() {
        System.out.println();
        System.out.println("잘못된 사람을 입력하셨습니다. 다시 입력해주세요.");
    }

    public void exit() {
        System.out.println();
        System.out.print("게임을 종료합니다.");
        System.exit(0);
    }
}
