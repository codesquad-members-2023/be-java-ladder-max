package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private List<String> names = new ArrayList<>();

    public Names(String[] nameArr) {
        for(String name : nameArr){
            names.add(name);
        }
    }

    public String makeNameRow() {
        String nameRow = "";

        for(String name: names){
            nameRow += makeName(name) + " ";
        }

        return nameRow;
    }

    public String makeName(String name) {
        int len = name.length();
        switch (len){
            case 1:
                name = "  " + name + "  ";
                break;
            case 2:
                name = "  " + name + " ";
                break;
            case 3:
                name = " " + name + " ";
                break;
            case 4:
                name = name + " ";
                break;
        }
        return name;
    }
}
