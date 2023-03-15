package kr.codesquad;

import java.util.List;

public class Line {
    private static final String RUNG = "=".repeat(5);
    private static final String BLANK = " ".repeat(5);
    private static final String POLE = "|";
    private final List<Boolean> line;

    public Line (List<Boolean> line) {
        this.line = line;
    }

    public String drawLine() {
        StringBuilder sb = new StringBuilder();

        sb.append(POLE);
        for (Boolean rung : line) {
            sb.append(drawRung(rung));
            sb.append(POLE);
        }
        return sb.toString();
    }

    private String drawRung(boolean rung) {
        if (rung) {
            return RUNG;
        }
        return BLANK;
    }
}
