package kr.codesquad.view;

import kr.codesquad.domain.LadderResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

    public Optional<List<String>> inputGoals() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        try {
            return Optional.of(readGoals(scanner.nextLine()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    private List<String> readGoals(String input) {
        return parseValidNames(input.split(","));
    }

    private List<String> readPlayerNames(String input) {
        return toPlayerNames(input.split(","));
    }

    private List<String> toPlayerNames(String[] inputNames) {
        final List<String> validPlayerNames = parseValidNames(inputNames);

        if (hasDuplicateName(validPlayerNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        return new ArrayList<>(validPlayerNames);
    }

    private boolean hasDuplicateName(List<String> validPlayerNames) {
        return new HashSet<>(validPlayerNames).size() != validPlayerNames.size();
    }

    private List<String> parseValidNames(String[] names) {
        return Arrays.stream(names)
                .map(this::parseValidName)
                .collect(Collectors.toList());
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

    public String toFormattedString(List<String> lists) {
        return lists.stream()
                .map(str -> String.format("%-6s", str))
                .collect(Collectors.joining());
    }

    public void printLadder(List<String> playerNames, String ladderShape, List<String> goals) {
        System.out.println("\n실행결과\n");

        System.out.println(toFormattedString(playerNames));
        System.out.println(ladderShape);
        System.out.println(toFormattedString(goals));
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
