package kr.codesquad.domain;

public enum LadderPart {
    BAR("|"),
    BRIDGE("-----"),
    EMPTY("     ");

    private final String shape;

    LadderPart(String shape) {
        this.shape = shape;
    }

    public static LadderPart makeRandomBridge() {
        if (isUpperThanPercent()) {
            return BRIDGE;
        }

        return EMPTY;
    }

    private static boolean isUpperThanPercent() {
        return Math.random() > 0.7;
    }

    @Override
    public String toString() {
        return shape;
    }
}