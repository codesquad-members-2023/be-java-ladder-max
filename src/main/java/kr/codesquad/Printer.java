package kr.codesquad;

import java.util.List;

public class Printer {
    public void printResult(List<List<String>> ladderBoard, List<String> namesList) {
        printNames(namesList);
        printLadder(ladderBoard);
    }
    private void printNames(List<String> namesList) {
        StringBuilder makeNamesOneString = new StringBuilder();
        makeNamesOneString.append(" ");
        for (int namesListIndex = 0; namesListIndex < namesList.size(); namesListIndex++) {
            makeNamesOneString.append(" ");
            makeNamesOneString.append(String.format("%5s", namesList.get(namesListIndex)));
        }
        System.out.println(makeNamesOneString);
    }
    private void printLadder(List<List<String>> ladderBoard) {
        for (int LadderFloorNum = 0; LadderFloorNum < ladderBoard.size(); LadderFloorNum++) {
            printLadderFloorElements(ladderBoard, LadderFloorNum);
        }
    }
    private void  printLadderFloorElements(List<List<String>> ladderBoard, int LadderFloorNum) {
        System.out.print("    ");
        for (String LadderFloorElements : ladderBoard.get(LadderFloorNum)) {
            System.out.print(LadderFloorElements);
        }
        System.out.print("\r\n");
    }
}
