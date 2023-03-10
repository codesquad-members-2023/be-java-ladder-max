package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Elements {
    private List<String> elements = new ArrayList<>();

    public Elements(String[] inputArr) {
        for (String element : inputArr) {
            elements.add(element);
        }
    }

    public int size() {
        return elements.size();
    }

    public String get(int index) {
        return elements.get(index);
    }

    public String toString() {
        String row = "";
        for (String element : elements) {
            row += setFormat(element) + " ";
        }

        return row;
    }

    public String setFormat(String element) {
        int len = element.length();
        switch (len) {
            case 1:
                element = "  " + element + "  ";
                break;
            case 2:
                element = "  " + element + " ";
                break;
            case 3:
                element = " " + element + " ";
                break;
            case 4:
                element = element + " ";
                break;
        }
        return element;
    }
}
