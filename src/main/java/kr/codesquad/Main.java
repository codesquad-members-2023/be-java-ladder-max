package kr.codesquad;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputView outputView = new OutputView();

        outputView.printNamesRequest();
        ArrayList<String> nameList = new InputCheck().putNameList();

        outputView.printHeightRequest();
        int height = new InputCheck().putHeight();

        new Ladder().makeLadder(nameList.size(), height);
        new OutputView().printLadder(nameList, height);
    }
}