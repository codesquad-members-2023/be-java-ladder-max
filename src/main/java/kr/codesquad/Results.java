package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;

public class Results {
    public HashMap<String, String> results = new HashMap<>();

    public HashMap<String, String> saveResult(ArrayList<Integer> connection, ArrayList<String> nameList, ArrayList<String> resultList) {
        for (int i = 0; i < connection.size(); i++) {
            int resultIndex = connection.get(i);
            results.put(nameList.get(i), resultList.get(resultIndex));
        }
        return results;
    }
}
