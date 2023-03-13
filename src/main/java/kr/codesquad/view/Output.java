package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;

public class Output {
    public void print(ArrayList<String> names, Ladder ladder, ArrayList<String> results) {
        System.out.print("\n--------실행 결과--------\n\n");
        printNames(names);
        printLadder(ladder);
        printResults(results);
    }

    private void printNames(ArrayList<String> names) {
        String[] blank = {"  ", "  ", " ", "", ""};
        names.forEach(name -> System.out.print(String.format("%-5s", blank[name.length() - 1] + name) + " "));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        System.out.print(ladder);
    }

    private void printResults(ArrayList<String> results) {
        String[] blank = {"  ", "  ", " ", "", ""};
        results.forEach(result -> System.out.print(String.format("%-5s", blank[result.length() - 1] + result) + " "));
        System.out.println();
    }
}
