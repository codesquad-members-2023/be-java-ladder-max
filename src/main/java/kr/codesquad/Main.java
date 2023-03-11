package kr.codesquad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();
        outputView.printInit();
        outputView.printNamesRequest();
        ArrayList<String> nameList = new InputCheck().putNameList();
        outputView.printResultsRequest();
        ArrayList<String> resultList = new InputCheck().putResultList(nameList.size());
        outputView.printHeightRequest();
        int height = new InputCheck().putHeight();

        Ladder ladder = new Ladder();
        ArrayList<Row> ladderList = ladder.makeLadder(nameList.size(), height);
        new OutputView().printLadder(ladderList, nameList, height, resultList);
        HashMap<String,String> results = ladder.setConnection(nameList, resultList);//사다리 로직

        String name = "";
        while(!name.equals("close")) {
            outputView.printPersonRequest();
            name = new InputCheck().getName(nameList);
            System.out.println(outputView.printResult(results, name));
        }
    }
}