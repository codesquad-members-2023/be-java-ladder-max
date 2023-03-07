package kr.codesquad;

public class Output {
    public void printLadder(boolean[][] rungs) {
        for(boolean[] row : rungs) {
            System.out.println(writeOneRow(row));
        }
    }

    private String writeOneRow(boolean[] rungRow) {
        StringBuilder sb = new StringBuilder();

        sb.append("|");
        for(boolean rung : rungRow) {
            sb.append(convertRungToString(rung));
            sb.append("|");
        }
        return sb.toString();
    }

    private String convertRungToString(boolean rung) {
        if (hasRung(rung)) {
            return " - ";
        }
        return "   ";
    }

    private boolean hasRung(boolean rung) {
        if(rung) return true;
        return false;
    }
}
