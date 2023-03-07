package kr.codesquad;

import java.util.regex.Pattern;

public class LadderValidator {

    private final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
    private final int minNumberOfPeople;
    private final int minLadderHeight;

    public LadderValidator(int minNumberOfPeople, int minLadderHeight) {
        this.minNumberOfPeople = minNumberOfPeople;
        this.minLadderHeight = minLadderHeight;
    }

    public String validateNumberOfPeople(String text) {
        if (!NUMBER_FORMAT.matcher(text).matches()) {
            throw new InvalidPersonNumber();
        }
        if (!moreThanMinNumberOfPeople(text)) {
            throw new InvalidPersonNumber();
        }
        return text;
    }

    private boolean moreThanMinNumberOfPeople(String text) {
        return Integer.parseInt(text) >= minNumberOfPeople;
    }

    public String validateLadderHeight(String text) {
        if (!NUMBER_FORMAT.matcher(text).matches()) {
            throw new InvalidMaximumLadderHeight();
        }
        if (!moreThanMinLadderHeight(text)) {
            throw new InvalidMaximumLadderHeight();
        }
        return text;
    }

    private boolean moreThanMinLadderHeight(String text) {
        return Integer.parseInt(text) >= minLadderHeight;
    }
}
