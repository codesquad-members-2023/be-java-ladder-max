package kr.codesquad.view;

import java.util.List;

import static kr.codesquad.util.ValidationPlayerName.MAX_LENGTH;

public class OutputLadder {
    public void printPlayerNames(List<String> playerList) {
        for(String name : playerList) {
            System.out.print(namesPrintFormat(name));
        }
        System.out.println();
    }

    private String namesPrintFormat(String name) {
        int nameCellLength = MAX_LENGTH + 1;
        int nameLength = name.length();
        int leftPadding = ((nameCellLength - nameLength) / 2) + ((nameCellLength - nameLength) % 2);
        int rightPadding = (nameCellLength - nameLength) / 2;
        return String.format("%s%s%s", " ".repeat(leftPadding), name, " ".repeat(rightPadding));
    }
    public void printLadder(String[][] finishedLadder) {
        System.out.println(ladderPrintFormat(finishedLadder));
    }

    private String ladderPrintFormat(String[][] finishedLadder) {
        StringBuilder sb = new StringBuilder();
        for(String[] row : finishedLadder) {
            appendRow(sb, row);
        }
        return sb.toString();
    }

    private void appendRow(StringBuilder sb, String[] row) {
        sb.append(" ".repeat((MAX_LENGTH + 1) / 2));
        for(String cell : row) {
            sb.append(cell);
        }
        sb.append("\n");
    }
}
