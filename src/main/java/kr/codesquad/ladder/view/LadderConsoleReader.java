package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kr.codesquad.ladder.domain.InvalidNameOfPeopleException;
import kr.codesquad.ladder.domain.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.domain.LadderValidator;

public class LadderConsoleReader implements LadderReader {

    private static final Pattern NAME_DELIMITER = Pattern.compile("\\s*,\\s*");

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
    public List<String> readNameOfPeople() {
        List<String> namesOfPeople = new ArrayList<>();
        while (namesOfPeople.size() == 0) {
            ladderWriter.writeNamesOfPeopleIntro();
            namesOfPeople = readNamesOfPeopleTextAndToStringList();
        }
        return namesOfPeople;
    }

    private List<String> readNamesOfPeopleTextAndToStringList() {
        List<String> namesOfPeople = new ArrayList<>();
        try {
            String text = reader.readLine();
            validator.validateNamesOfPeople(text, NAME_DELIMITER.pattern());
            namesOfPeople = toList(text);
        } catch (InvalidNameOfPeopleException e) {
            ladderWriter.writeInvalidReadNumber(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return namesOfPeople;
    }

    private List<String> toList(String text) {
        List<String> namesOfPeople = new ArrayList<>();
        String[] nameArr = text.split(NAME_DELIMITER.pattern());
        Collections.addAll(namesOfPeople, nameArr);
        return namesOfPeople;
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
        } catch (InvalidNumberOfMinimumLadderHeightException e) {
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
