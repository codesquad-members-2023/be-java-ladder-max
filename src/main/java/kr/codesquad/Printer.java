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
        for (int ladderFloorNum = 0; ladderFloorNum < ladderBoard.size(); ladderFloorNum++) {
            printLadderFloorElements(ladderBoard, ladderFloorNum);
        }
    }

    private void printLadderFloorElements(List<List<String>> ladderBoard, int ladderFloorNum) {
        System.out.print("    ");
        for (String ladderFloorElements : ladderBoard.get(ladderFloorNum)) {
            System.out.print(ladderFloorElements);
        }
        System.out.print("\r\n");
    }
}
