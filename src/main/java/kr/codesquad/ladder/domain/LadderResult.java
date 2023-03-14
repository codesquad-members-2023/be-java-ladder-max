package kr.codesquad.ladder.domain;

import java.util.Objects;

public class LadderResult {

    private static final int LENGTH_LIMIT = 5;

    private final String value;

    public LadderResult(String value) {
        validateLengthOfLadderResult(value);
        this.value = value;
    }

    public void validateLengthOfLadderResult(String value) {
        if (value.length() > LENGTH_LIMIT) {
            throw new InvalidLengthOfLadderResultException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderResult)) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
