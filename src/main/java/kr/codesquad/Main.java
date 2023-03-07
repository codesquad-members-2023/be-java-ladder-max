package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Output output = new Output();

        output.printNamesRequest();
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(br.readLine().split(",")));

        output.printHeightRequest();
        int height = Integer.parseInt(br.readLine());

        new Ladder().makeLadder(nameList.size(), height);
        output.printLadder(nameList);
    }
}