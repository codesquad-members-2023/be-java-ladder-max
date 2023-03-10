package kr.codesquad.domain;

public enum LadderPart {
    POLES("|"),
    CROSSBAR("-----"),
    EMPTY("     ");

    private final String shape;

    LadderPart(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public static LadderPart from(int width) {
        if (width % 2 == 0) {
            return POLES;
        }

        if (Math.random() > 0.6) {
            return CROSSBAR;
        }

        return EMPTY;
    }
}