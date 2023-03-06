package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Screen {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    public static void printResult(List<String> playerNames, List<String> ladderMap) {
        StringBuilder stringBuilder = new StringBuilder();

        printPlayerNames(playerNames, stringBuilder);
        printLadderMap(ladderMap, stringBuilder);

        System.out.println(stringBuilder);
    }

    private static void printPlayerNames(List<String> playerNames, StringBuilder stringBuilder) {
        for (String playerName : playerNames) {
            stringBuilder.append(String.format("%-6s", playerName));
        }

        stringBuilder.append("\n");
    }

    private static void printLadderMap(List<String> ladderMap, StringBuilder stringBuilder) {
        ladderMap.forEach(ladderLine -> stringBuilder.append(ladderLine).append("\n"));
    }
}
