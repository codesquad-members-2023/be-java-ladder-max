package kr.codesquad;

import java.util.Optional;

public class LadderGame implements Runnable {
  private final int MIN_SIZE_OF_PEOPLE = 2;
  private final int MIN_SIZE_OF_LADDER = 1;
  private final Console console;
  private final RandomLadderGenerator generator;

  public LadderGame(Console console, RandomLadderGenerator generator) {
    this.console = console;
    this.generator = generator;
  }

  @Override
  public void run() {
    int sizeOfPeople, sizeOfLadder;
    sizeOfPeople = inputToValue("참여할 사람은 몇 명인가요?", MIN_SIZE_OF_PEOPLE);
    sizeOfLadder = inputToValue("최대 사다리 높이는 몇 개인가요?", MIN_SIZE_OF_LADDER);

    Ladder ladder = generator.generate(sizeOfPeople,sizeOfLadder);
    System.out.println(ladder);
  }

  private Optional<Integer> parse(String inputString, int limit) {
    try {
      int result = Integer.parseInt(inputString);
      if (result < limit) return Optional.empty();
      return Optional.of(result);
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

  private int inputToValue(String prompt, int limit) {
    while (true) {
      String inputString = console.input(prompt);
      Optional<Integer> parsedValue = parse(inputString, limit);
      if (parsedValue.isEmpty()) {
        console.inputError();
        continue;
      }
      return parsedValue.get();
    }
  }
}
