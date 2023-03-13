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

    public void printResultPerson(Ladder ladder, ArrayList<String> results
            , int position, int namesSize, int countOfLadder) {
        System.out.print("\n실행 결과\n");
        int index = 2 * position;
        if(position == -1) { //all일 경우
            for (int i = 0; i < namesSize; i++) {
                for (int j = 0; j < countOfLadder; j++) {
                    index = ladder.moveVertically(j, 2 * i);
                }
                System.out.print(results.get(index/2) + "\n\n");
            }
        } else {
            for (int i = 0; i < countOfLadder; i++) {
                index = ladder.moveVertically(i, index);
            }
        }
        System.out.print(results.get(index/2) + "\n\n");
    }
}
