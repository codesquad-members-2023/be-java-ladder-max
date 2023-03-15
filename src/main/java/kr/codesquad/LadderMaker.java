package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class LadderMaker {
    private final Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> namesList;

    public void make(ArrayList<String> namesInput, int LadderHeight) {
        namesList = namesInput;
        int bridgeOrSpace = 0;
        ladderBoard = new ArrayList<>();
        for (int ladderFloorNum = 0; ladderFloorNum < LadderHeight; ladderFloorNum++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(ladderFloorNum).add("|");
           makeRemainParts(bridgeOrSpace, ladderFloorNum);
        }
    }
    private void  makeRemainParts (int bridgeOrSpace, int ladderFloorsNum){
        makeIndexNumber1(bridgeOrSpace, ladderFloorsNum);
        for (int LadderFloorIndex = 1; LadderFloorIndex < namesList.size() - 1; LadderFloorIndex++) {
            bridgeOrSpace = 0;
            makeBridgeNotSecond(bridgeOrSpace, LadderFloorIndex, ladderFloorsNum);
        }
    }
    private void makeIndexNumber1(int bridgeOrSpace, int ladderFloorsNum){
        if (random.nextBoolean()) {
            bridgeOrSpace = 1;
        }
        switch (bridgeOrSpace) {
            case 1:
                ladderBoard.get(ladderFloorsNum).add("-----");
                ladderBoard.get(ladderFloorsNum).add("|");
                break;
            case 0:
                ladderBoard.get(ladderFloorsNum).add("     ");
                ladderBoard.get(ladderFloorsNum).add("|");
                break;
        }
    }
    private void makeBridgeNotSecond(int bridgeOrSpace, int LadderFloorIndex, int ladderFloors){
        if (random.nextBoolean() && ladderBoard.get(ladderFloors).get(LadderFloorIndex - 1).equals("     ")) {
            bridgeOrSpace = 1;
        }
        switch (bridgeOrSpace) {
            case 1:
                ladderBoard.get(ladderFloors).add("-----");
                ladderBoard.get(ladderFloors).add("|");
                break;
            case 0:
                ladderBoard.get(ladderFloors).add("     ");
                ladderBoard.get(ladderFloors).add("|");
                break;
        }
    }
    public void printResult() {
        printNames();
        printLadder();
    }
    private void printNames() {
        StringBuilder makeNamesOneString = new StringBuilder();
        makeNamesOneString.append(" ");
        for (int namesListIndex = 0; namesListIndex < namesList.size(); namesListIndex++) {
            makeNamesOneString.append(" ");
            makeNamesOneString.append(String.format("%5s", namesList.get(namesListIndex)));
        }
        System.out.println(makeNamesOneString);
    }
    private void printLadder() {
        for (int LadderFloorNum = 0; LadderFloorNum < ladderBoard.size(); LadderFloorNum++) {
            printLadderFloorElements(LadderFloorNum);
        }
    }
    private void  printLadderFloorElements(int LadderFloorNum) {
        System.out.print("    ");
        for (String LadderFloorElements : ladderBoard.get(LadderFloorNum)) {
            System.out.print(LadderFloorElements);
        }
        System.out.print("\r\n");
    }
}
