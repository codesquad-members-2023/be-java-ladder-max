package kr.codesquad;

public class Output {
    private static final String POLE = "|";
    private static final String RUNG = " - ";
    private static final String BLANK = "   ";
    
    public void printLadder(boolean[][] rungs) {
        for(boolean[] row : rungs) {
            System.out.println(writeOneRow(row));
        }
    }

    private String writeOneRow(boolean[] rungRow) {
        StringBuilder sb = new StringBuilder();

        sb.append(POLE);
        for(boolean rung : rungRow) {
            sb.append(convertRungToString(rung));
            sb.append(POLE);
        }
        return sb.toString();
    }

    private String convertRungToString(boolean rung) {
        if (hasRung(rung)) {
            return RUNG;
        }
        return BLANK;
    }

    private boolean hasRung(boolean rung) {
        if(rung) return true;
        return false;
    }
}
