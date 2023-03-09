package kr.codesquad;

import java.util.Arrays;

public class Output {
    public static void printLadder(Ladder ladder) {
        ladder.ladder.stream()
                .map(a -> String.join("", a))
                .forEach(System.out::println);
    }
}
