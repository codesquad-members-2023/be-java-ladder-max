package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class InputCheck {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ArrayList<String> putNameList() throws IOException {
        boolean check;
        String[] names;
        do {
            names = br.readLine().split(",");
            check = checkInputLength(names);
        } while (!check);
        return new ArrayList<>(Arrays.asList(names));
    }
    public ArrayList<String> putResultList(int nameSize) throws IOException {
        boolean checkLength;
        boolean checkSize;
        String[] results;
        do {
            results = br.readLine().split(",");
            checkLength = checkInputLength(results);
            checkSize = checkResultSize(nameSize, results.length);
        } while (!checkLength || !checkSize);
        return new ArrayList<>(Arrays.asList(results));
    }

    public String getName(ArrayList<String> nameList) throws IOException {
        boolean check;
        String name;
        do {
            name = br.readLine();
            check = checkNameList(name, nameList);
        } while (!check);
        return name;
    }

    public int putHeight() throws IOException {
        boolean check;
        String height;
        do {
            height = br.readLine();
            check = checkHeight(height);
        } while (!check);
        return Integer.parseInt(height);
    }

    private boolean checkInputLength(String[] names) {
        OutputView outputview = new OutputView();
        ArrayList<Boolean> checkBox = new ArrayList<>();
        boolean check;
        for (int i = 0; i < names.length; i++) {
            check = 1 <= names[i].length() && names[i].length() <= 5;
            checkBox.add(check);
        }
        if (checkBox.contains(false)) {
            outputview.printNameError();
            return false;
        }
        return true;
    }

    private boolean checkResultSize(int nameSize, int resultSize){
        if(nameSize == resultSize) return true;
        new OutputView().printCountMatchError();
        return false;
    }

    private boolean checkNameList(String name, ArrayList<String> nameList) {
        OutputView outputview = new OutputView();
        if (name.equals("all")) return true;
        else if(name.equals("close")) {
            outputview.printEnd();
        }
        else if (!nameList.contains(name)) {
            outputview.printNameNull();
            return false;
        }
        return true;
    }

    private boolean checkHeight(String height) {
        OutputView outputview = new OutputView();
        if (!isInteger(height) || Integer.parseInt(height) < 0) {
            outputview.printNumberError();
            return false;
        }
        return true;
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
