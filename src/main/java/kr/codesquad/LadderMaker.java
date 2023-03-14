package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.StringBuilder;

public class LadderMaker {
    private final Random random = new Random();
    private List<List<String>> ladderBoard;
    private List<String> names;

    public void setNamesList(ArrayList<String> returnInit) {
        names = returnInit;
    }
    void makeFirstBridge(int x, int i){
        if (random.nextBoolean()) {
            x = 1;
        }

        switch (x) {
            case 1:
                ladderBoard.get(i).add("-----");
                ladderBoard.get(i).add("|");
                break;
            case 0:
                ladderBoard.get(i).add("     ");
                ladderBoard.get(i).add("|");
                break;
        }
    }
    public void make(int height) {
        int x = 0;
        ladderBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderBoard.add(new ArrayList<>());
            ladderBoard.get(i).add("|");
           makeAllExceptLeftSide(x, i);
        }
    }
    void makeAllExceptLeftSide (int x, int i){
        makeFirstBridge(x, i);
        for (int j = 1; j < names.size() - 1; j++) {
            x = 0;
            makeBridgeValueByBeforeValue(x, j, i);
        }
    }
    void makeBridgeValueByBeforeValue(int x, int j, int i){
        if (random.nextBoolean() && ladderBoard.get(i).get(j - 1).equals("     ")) {
            x = 1;
        }
        switch (x) {
            case 1:
                ladderBoard.get(i).add("-----");
                ladderBoard.get(i).add("|");
                break;
            case 0:
                ladderBoard.get(i).add("     ");
                ladderBoard.get(i).add("|");
                break;
        }
    }
    public void printResult() {
        printNames();
        printLadderFloor();
    }
    private void printNames() {
        StringBuilder generateAllNameString = new StringBuilder();
        generateAllNameString.append(" ");
        for (int i = 0; i < names.size(); i++) {
            generateAllNameString.append(" ");
            generateAllNameString.append(String.format("%5s", names.get(i)));
        }
        System.out.println(generateAllNameString);
    }
    private void printLadderFloor() {
        for (int i = 0; i < ladderBoard.size(); i++) {
            printPillarAndBridges(i);
        }
    }
    private void printPillarAndBridges(int i) {
        System.out.print("    ");
        for (String j : ladderBoard.get(i)) {
            System.out.print(j);
        }
        System.out.print("\r\n");
    }
}
