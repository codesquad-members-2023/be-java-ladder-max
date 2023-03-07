package kr.codesquad;

import java.util.ArrayList;

public class Names {
    public String getNames(ArrayList<String> nameList) {
        StringBuilder namesRow = new StringBuilder();
        for (int i = 0; i < nameList.size(); i++) {
            namesRow.append(putSpaces(nameList.get(i))).append(" ");
        }
        return namesRow.toString();
    }

    public String putSpaces(String name) {
        StringBuilder sb = new StringBuilder();
        switch (name.length()) {
            case 1 -> sb.append("  ").append(name).append("  ");
            case 2 -> sb.append("  ").append(name).append(" ");
            case 3 -> sb.append(" ").append(name).append(" ");
            case 4 -> sb.append(name).append(" ");
            default -> sb.append(name);
        }
        return sb.toString();
    }
}
