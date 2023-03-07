package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    private final BufferedReader br;
    private final LadderValidator validator;

    public ConsoleInput(LadderValidator validator) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
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
        try {
            String text = br.readLine();
            validator.validateNumberOfPeople(text);
            return toInt(text);
        } catch (InvalidPersonNumber e) {
            ConsoleOutput.printInvalidInputNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
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
        try {
            String text = br.readLine();
            validator.validateLadderHeight(text);
            return toInt(text);
        } catch (InvalidPersonNumber e) {
            ConsoleOutput.printInvalidInputNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    private int toInt(String text) {
        return Integer.parseInt(text);
    }
}
