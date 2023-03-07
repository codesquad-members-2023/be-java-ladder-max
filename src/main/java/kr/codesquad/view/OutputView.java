package kr.codesquad.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLadder(List<List<String>> ladder) {
        String result = ladder.stream()
                .map(oneLine -> String.join("", oneLine))
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }
}
