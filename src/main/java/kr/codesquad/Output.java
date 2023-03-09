package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;

public class Output {
    public static void print(ArrayList<String> names, Ladder ladder) {
        System.out.print("\n-----실행 결과-----\n\n");
        printNames(names);
        printLadder(ladder);
    }

    public static void printNames(ArrayList<String> names) {
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.ladder.stream()
                .map(a -> String.join("", a))
                .forEach(System.out::println);
    }
}
