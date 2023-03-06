package kr.codesquad;

import java.util.regex.Pattern;

public class LadderValidator {
    private final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
    private final int minPerson;
    private final int minLadderHeight;

    public LadderValidator(int minPerson, int minLadderHeight) {
        this.minPerson = minPerson;
        this.minLadderHeight = minLadderHeight;
    }

    public boolean validatePerson(String text) {
        return NUMBER_FORMAT.matcher(text).matches() && moreThanMinPerson(text);
    }

    private boolean moreThanMinPerson(String text){
        return Integer.parseInt(text) >= minPerson;
    }

    public boolean validateLadderHeight(String text){
        return NUMBER_FORMAT.matcher(text).matches() && moreThanMinLadderHeight(text);
    }

    private boolean moreThanMinLadderHeight(String text){
        return Integer.parseInt(text) >= minLadderHeight;
    }
}
