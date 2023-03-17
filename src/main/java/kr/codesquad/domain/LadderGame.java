package kr.codesquad.domain;

import kr.codesquad.view.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class LadderGame implements Runnable {
    private final int MIN_SIZE_OF_PEOPLE = 2;
    private final int MIN_SIZE_OF_LADDER = 1;
    private final int MAX_NAME_SIZE = 5;
    private final Console console;
    private final RandomLadderGenerator generator;

    public LadderGame(Console console, RandomLadderGenerator generator) {
        this.console = console;
        this.generator = generator;
    }

    @Override
    public void run() {
        ArrayList<Player> players = inputNamesToPlayers();
        int ladderSize = inputNumberToLadderSize();

        Ladder ladder = generator.generate(players.size(), ladderSize);
        printPlayerList(players); // 사람 이름 출력
        System.out.println(ladder); // 사다리 출력
    }

    private void printPlayerList(ArrayList<Player> playerArrayList) {
        StringBuilder sb = new StringBuilder();
        for (var player : playerArrayList) {
            sb.append(alignCenter(player.getName())).append(" ");
        }
        System.out.println(sb);
    }

    // 5글자를 기준으로 이름을 가운데로 정렬하는 메소드
    private String alignCenter(String name) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < (MAX_NAME_SIZE - name.length()) / 2) sb.append(" ");
        sb.append(name);
        while (sb.length() < MAX_NAME_SIZE) sb.append(" ");
        return sb.toString();
    }

    private ArrayList<Player> inputNamesToPlayers() {
        var input = console.input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        if (input.isEmpty()) return inputNamesToPlayers();
        var parsedValue = parsePlayerList(input.get());
        return parsedValue.orElseGet(this::inputNamesToPlayers);
    }

    private Optional<ArrayList<Player>> parsePlayerList(String inputString) {
        String[] playerNames = inputString.split(",");
        if (!isValidPlayer(playerNames)) return Optional.empty();

        ArrayList<Player> result = new ArrayList<>();
        for (int i = 0; i < playerNames.length; i++) {
            result.add(new Player(playerNames[i], i));
        }
        return Optional.of(result);
    }

    private boolean isValidPlayer(String[] playerNames) {
        if (playerNames.length < MIN_SIZE_OF_PEOPLE) return false; // 최소 플레이어수 확인
        return Arrays.stream(playerNames).allMatch(name -> name.length() < MAX_NAME_SIZE);
    }

    private Optional<Integer> parseLadderSize(String inputString) {
        try {
            int result = Integer.parseInt(inputString);
            if (result < MIN_SIZE_OF_LADDER) return Optional.empty();
            return Optional.of(result);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private int inputNumberToLadderSize() {
        var input = console.input("최대 사다리 높이는 몇 개인가요?");
        if (input.isEmpty()) return inputNumberToLadderSize();
        var parsedValue = parseLadderSize(input.get());
        return parsedValue.orElseGet(this::inputNumberToLadderSize);
    }
}
