package kr.codesquad.ladder.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class LadderValidator {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]{1,5}");
    private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
    private final int minNumberOfPeople;
    private final int minLadderHeight;

    public LadderValidator(int minNumberOfPeople, int minLadderHeight) {
        this.minNumberOfPeople = minNumberOfPeople;
        this.minLadderHeight = minLadderHeight;
    }

    public void validateNamesOfPeople(String text, String delimiter) {
        String[] names = text.split(delimiter);
        if (!validateNameFormat(names)) {
            throw new InvalidNameOfPeopleException();
        }
        if (!moreThanMinNumberOfPeople(names)) {
            throw new InvalidNumberOfPeopleException();
        }
    }

    private boolean validateNameFormat(String[] names) {
        return Arrays.stream(names).allMatch(name -> NAME_FORMAT.matcher(name).matches());
    }

    private boolean moreThanMinNumberOfPeople(String[] names) {
        return names.length >= minNumberOfPeople;
    }

    public void validateLadderHeight(String text) {
        if (!validateNumberFormat(text)) {
            throw new InvalidNumberOfMinimumLadderHeightException();
        }
        if (!moreThanMinLadderHeight(text)) {
            throw new InvalidNumberOfMinimumLadderHeightException();
        }
    }

    private boolean validateNumberFormat(String text) {
        return NUMBER_FORMAT.matcher(text).matches();
    }

    private boolean moreThanMinLadderHeight(String text) {
        return Integer.parseInt(text) >= minLadderHeight;
    }
}
