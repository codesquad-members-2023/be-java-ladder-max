package kr.codesquad;

public enum LadderPart {
    POLES("|"),
    CROSSBAR("-----"),
    NONE("     ");

    private final String shape;

    LadderPart(String shape) {
        this.shape = shape;
    }

    public static LadderPart create(int width) {
        if (width % 2 == 0) {
            return POLES;
        }

        if (Math.random() > 0.5) {
            return CROSSBAR;
        }

        return NONE;
    }

    @Override
    public String toString() {
        return shape;
    }
}
