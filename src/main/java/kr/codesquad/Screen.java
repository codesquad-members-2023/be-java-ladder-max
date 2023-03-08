package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Screen {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPlayerNumber() {
        Optional<Integer> playerNumber = Optional.empty();

        while (playerNumber.isEmpty()) {
            System.out.println("참여할 사람은 몇 명인가요?");
            playerNumber = readInt();
        }

        return playerNumber.get();
    }

    public static int inputLadderHeight() {
        Optional<Integer> ladderHeight = Optional.empty();

        while (ladderHeight.isEmpty()) {
            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            ladderHeight = readInt();
        }

        return ladderHeight.get();
    }

    private static Optional<Integer> readInt() {
        try {
            final int input = Integer.parseInt(scanner.nextLine().trim());
            return toOptionalPositiveNumber(input);
        } catch (NumberFormatException ex) {
            System.out.println("숫자를 입력해주세요.");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    private static Optional<Integer> toOptionalPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해 주세요.");
        }

        return Optional.of(number);
    }

    public static List<String> inputPlayerNames() {
        Optional<List<String>> playerNames = Optional.empty();
        while (playerNames.isEmpty()) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            playerNames = readPlayerNames();
        }

        return playerNames.get();
    }

    private static Optional<List<String>> readPlayerNames() {
        try {
            return Optional.of(toValidPlayerNames(scanner.nextLine().split(",")));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    private static List<String> toValidPlayerNames(String[] inputNames) {
        final Set<String> validPlayerNames = parseValidNames(inputNames);

        if (inputNames.length != validPlayerNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        return new ArrayList<>(validPlayerNames);
    }

    private static Set<String> parseValidNames(String[] names) {
        return Arrays.stream(names)
                .map(Screen::parseValidName)
                .collect(Collectors.toSet());
    }

    private static String parseValidName(String input) {
        final String name = input.trim();
        if (isInValidName(name)) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }

        return name;
    }

    private static boolean isInValidName(String name) {
        return !name.matches("^[a-zA-Z0-9]{1,5}$");
    }

    public static void printResult(List<String> outputLines) {
        System.out.println("\n실행결과\n");

        System.out.println(String.join("\n", outputLines));
    }
}
