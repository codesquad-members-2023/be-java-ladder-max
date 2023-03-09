package kr.codesquad;

import java.util.regex.Pattern;

public class LadderValidator {

    private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
    private final int minNumberOfPeople;
    private final int minLadderHeight;

    public LadderValidator(int minNumberOfPeople, int minLadderHeight) {
        this.minNumberOfPeople = minNumberOfPeople;
        this.minLadderHeight = minLadderHeight;
    }

    public void validateNumberOfPeople(String text) {
        if (!NUMBER_FORMAT.matcher(text).matches()) {
            throw new InvalidNumberOfPeopleException();
        }
        if (!moreThanMinNumberOfPeople(text)) {
            throw new InvalidNumberOfPeopleException();
        }
    }

    private boolean moreThanMinNumberOfPeople(String text) {
        return Integer.parseInt(text) >= minNumberOfPeople;
    }

    public void validateLadderHeight(String text) {
        if (!NUMBER_FORMAT.matcher(text).matches()) {
            throw new InvalidNumberOfMaximumLadderHeightException();
        }
        if (!moreThanMinLadderHeight(text)) {
            throw new InvalidNumberOfMaximumLadderHeightException();
        }
    }

    private boolean moreThanMinLadderHeight(String text) {
        return Integer.parseInt(text) >= minLadderHeight;
    }
}
