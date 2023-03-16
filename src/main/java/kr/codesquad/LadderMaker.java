package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private final Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> namesList;
    private Printer printer = new Printer();

    public void make(ArrayList<String> namesInput, int ladderHeight) {
        namesList = namesInput;
        int bridgeOrSpace = 0;
        ladderBoard = new ArrayList<>();
        for (int ladderFloorNum = 0; ladderFloorNum < ladderHeight; ladderFloorNum++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(ladderFloorNum).add("|");
           makeRemainParts(bridgeOrSpace, ladderFloorNum);
        }
        printer.printResult(ladderBoard, namesList);
    }
    private void  makeRemainParts (int bridgeOrSpace, int ladderFloorsNum){
        makeIndexNumber1(bridgeOrSpace, ladderFloorsNum);
        for (int ladderFloorIndex = 1; ladderFloorIndex < namesList.size() - 1; ladderFloorIndex++) {
            bridgeOrSpace = 0;
            makeBridgeNotSecond(bridgeOrSpace, ladderFloorIndex, ladderFloorsNum);
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
    private void makeBridgeNotSecond(int bridgeOrSpace, int ladderFloorIndex, int ladderFloors){
        if (random.nextBoolean() && ladderBoard.get(ladderFloors).get(ladderFloorIndex - 1).equals("     ")) {
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
}
