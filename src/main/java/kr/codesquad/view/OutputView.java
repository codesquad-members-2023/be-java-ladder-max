package kr.codesquad.view;

import kr.codesquad.domain.Line;

import java.util.List;

public class OutputView {

    public void printLadder(List<String> people, List<Line> ladders) {
        printPeople(people);
        for(Line line : ladders) {
            System.out.print("    |");
            System.out.println(line);
        }
    }

    public void printPeople(List<String> people) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        System.out.println(people.stream()
                .map(o -> " " + String.format("%5s", o))
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o)
                        , StringBuilder::append));
    }
}
