package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;

public class Output {
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
