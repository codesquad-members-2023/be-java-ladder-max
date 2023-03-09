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
            check = checkName(names);
        } while (!check);
        return new ArrayList<>(Arrays.asList(names));
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

    private boolean checkName(String[] names) {
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
