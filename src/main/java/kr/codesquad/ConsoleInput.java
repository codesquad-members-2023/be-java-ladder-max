package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    private final BufferedReader reader;
    private final LadderValidator validator;

    public ConsoleInput(BufferedReader reader, LadderValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public int readNumberOfPeople() {
        int numberOfPeople = 0;
        while (numberOfPeople == 0) {
            ConsoleOutput.printInputPersonIntro();
            numberOfPeople = readNumberOfPeopleTextAndToInt();
        }
        return numberOfPeople;
    }

    private int readNumberOfPeopleTextAndToInt() {
        int numberOfPeople = 0;
        try {
            String text = reader.readLine();
            validator.validateNumberOfPeople(text);
            numberOfPeople = toInt(text);
        } catch (InvalidPersonNumber e) {
            ConsoleOutput.printInvalidInputNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numberOfPeople;
    }

    public int readMaximumLadderHeight() {
        int maximumLadderHeight = 0;
        while (maximumLadderHeight == 0) {
            ConsoleOutput.printInputMaximumLadderHeightIntro();
            maximumLadderHeight = readMaximumLadderHeightTextAndToInt();
        }
        return maximumLadderHeight;
    }

    private int readMaximumLadderHeightTextAndToInt() {
        int maximumLadderHeight = 0;
        try {
            String text = reader.readLine();
            validator.validateLadderHeight(text);
            maximumLadderHeight = toInt(text);
        } catch (InvalidMaximumLadderHeight e) {
            ConsoleOutput.printInvalidInputNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maximumLadderHeight;
    }

    private int toInt(String text) {
        return Integer.parseInt(text);
    }
}
