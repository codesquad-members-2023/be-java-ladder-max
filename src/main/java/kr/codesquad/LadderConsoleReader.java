package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;

public class LadderConsoleReader implements LadderReader {

    private final BufferedReader reader;
    private final LadderValidator validator;
    private final LadderWriter ladderWriter;

    public LadderConsoleReader(BufferedReader reader,
        LadderValidator validator,
        LadderWriter ladderWriter) {
        this.reader = reader;
        this.validator = validator;
        this.ladderWriter = ladderWriter;
    }

    @Override
    public int readNumberOfPeople() {
        int numberOfPeople = 0;
        while (numberOfPeople == 0) {
            ladderWriter.writeNumberOfPeopleIntro();
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
        } catch (InvalidNumberOfPeopleException e) {
            ladderWriter.writeInvalidReadNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numberOfPeople;
    }

    @Override
    public int readMaximumLadderHeight() {
        int maximumLadderHeight = 0;
        while (maximumLadderHeight == 0) {
            ladderWriter.writeMaximumLadderHeightIntro();
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
        } catch (InvalidNumberOfMaximumLadderHeightException e) {
            ladderWriter.writeInvalidReadNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maximumLadderHeight;
    }

    private int toInt(String text) {
        return Integer.parseInt(text);
    }
}
