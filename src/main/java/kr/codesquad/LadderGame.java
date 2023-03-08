package kr.codesquad;

import java.io.IOException;

public class LadderGame implements Runnable {
  private final int MIN_SIZE_OF_PEOPLE = 2;
  private final int MIN_SIZE_OF_LADDER = 1;
  private final Console console;

  public LadderGame(Console console) {
    this.console = console;
  }

  @Override
  public void run() {
    int sizeOfPeople, sizeOfLadder;
    while (true) {
      try {
        String inputString = console.input("참여할 사람은 몇 명인가요?");
        sizeOfPeople = parse(inputString, MIN_SIZE_OF_PEOPLE);
        inputString = console.input("최대 사다리 높이는 몇 개인가요?");
        sizeOfLadder = parse(inputString, MIN_SIZE_OF_LADDER);
        break;
      } catch (IOException | NumberFormatException e) {
        console.inputError();
      }
    }

  }

  private int parse(String inputString, int limit) throws IOException {
    int result = Integer.parseInt(inputString);
    if (result < limit) {
      throw new IOException();
    }
    return result;
  }

}
