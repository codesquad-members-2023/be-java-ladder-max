package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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

    private static Optional<Integer> readInt() {
        try {
            return filterPositiveNumber(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException ex) {
            System.out.println("숫자를 입력해주세요.");
        } catch (IllegalArgumentException ex) {
            System.out.println("0보다 큰 숫자를 입력해 주세요.");
        }
        return Optional.empty();
    }

    private static Optional<Integer> filterPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        return Optional.of(number);
    }

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return Arrays.stream(scanner.nextLine().split(","))
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    public static void printResult(List<String> outputLines) {
        System.out.println("\n실행결과\n");

        System.out.println(String.join("\n", outputLines));
    }
}
