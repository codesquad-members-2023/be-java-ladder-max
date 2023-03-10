package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;

public class Output {
    public void print(ArrayList<String> names, Ladder ladder) {
        System.out.print("\n-----실행 결과-----\n\n");
        printNames(names);
        printLadder(ladder);
    }

    private void printNames(ArrayList<String> names) {
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.ladder.stream()
                .map(a -> String.join("", a))
                .forEach(System.out::println);
    }
}
