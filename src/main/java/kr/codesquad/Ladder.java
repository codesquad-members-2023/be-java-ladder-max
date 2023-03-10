package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;

public class Ladder {
    int countOfPerson;
    int ladderHeight;
    ArrayList<Row> list;
    ArrayList<Integer> connection = new ArrayList<>();

    public ArrayList<Row> makeLadder(int m, int n) {
        countOfPerson = m;
        ladderHeight = n;
        list = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            list.add(new Row(countOfPerson));
        }
        return list;
    }

    public HashMap<String, String> setConnection(ArrayList<String> nameList, ArrayList<String> resultList) {
        for (int i = 0; i < countOfPerson; i++) {
            connection.add(findConnection(i));
        }
        return new Results().saveResult(connection, nameList, resultList);
    }

    private int findConnection(int index) {
        for (int i = 0; i < ladderHeight; i++) {
            index = connectEach(i, index);
        }
        return index;
    }

    private int connectEach(int column, int index) {
        Row row = list.get(column);
        if (index == 0 && !row.getBool(index)) return index;
        else if (index == 0 && row.getBool(index)) return index + 1;
        else if (0 < index && index < countOfPerson - 1 && row.getBool(index - 1)) return index - 1;
        else if (0 < index && index < countOfPerson - 1 && !row.getBool(index - 1) && !row.getBool(index)) return index;
        else if (0 < index && index < countOfPerson - 1 && row.getBool(index)) return index + 1;
        else if (index == countOfPerson - 1 && row.getBool(index - 1)) return index - 1;
        return index;
    }
}