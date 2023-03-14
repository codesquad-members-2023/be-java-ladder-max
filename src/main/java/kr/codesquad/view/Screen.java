package kr.codesquad.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Screen {
    private final Scanner scanner;

    public Screen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<Integer> inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        try {
            return Optional.of(readInt(scanner.nextLine()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    private int readInt(String input) {
        try {
            return toPositiveNumber(Integer.parseInt(input.trim()));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private int toPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해 주세요.");
        }

        return number;
    }

    public Optional<List<String>> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            return Optional.of(readPlayerNames(scanner.nextLine()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    private List<String> readPlayerNames(String input) {
        return toPlayerNames(input.split(","));
    }

    private List<String> toPlayerNames(String[] inputNames) {
        final Set<String> validPlayerNames = parseValidNames(inputNames);

        if (hasDuplicateName(inputNames, validPlayerNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        return new ArrayList<>(validPlayerNames);
    }

    private boolean hasDuplicateName(String[] inputNames, Set<String> validPlayerNames) {
        return inputNames.length != validPlayerNames.size();
    }

    private Set<String> parseValidNames(String[] names) {
        return Arrays.stream(names)
                .map(this::parseValidName)
                .collect(Collectors.toSet());
    }

    private String parseValidName(String input) {
        final String name = input.trim();
        if (isInValidName(name)) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }

        return name;
    }

    private boolean isInValidName(String name) {
        final String playerNamePattern = "^[a-zA-Z0-9]{1,5}$";

        return !name.matches(playerNamePattern);
    }

    public String toPlayerLine(List<String> playerNames) {
        return playerNames.stream()
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining());
    }

    public void printResult(List<String> playerNames, String ladderShape) {
        System.out.println("\n실행결과\n");

        System.out.println(toPlayerLine(playerNames));
        System.out.println(ladderShape);
    }
}
