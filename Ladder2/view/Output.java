package Ladder2;

import java.util.ArrayList;

public class Output {
    public Output(ArrayList<ArrayList<String>> ladder, ArrayList<String> pplNames) {

        printLadder(ladder, pplNames);

    }

    private void printLadder(ArrayList<ArrayList<String>> ladder, ArrayList<String> pplNames) {
        StringBuilder result = new StringBuilder();
        result.append(appendNames(pplNames));
        for (int i = 0; i < ladder.size(); i++) {
            result.append(appendRow(i, ladder));
        }
        System.out.println(result);
    }

    private String appendNames(ArrayList<String> pplNames) {
        StringBuilder sb = new StringBuilder();
        int emptyCount = 0; int nameCount = 0;
        for (String name : pplNames) {
            emptyCount = 6  - nameCount - ((name.length() / 2) + (name.length() % 2));
            nameCount = name.length() - (name.length() / 2) - (name.length() % 2);
            sb.append(createEmptyString(emptyCount));
            sb.append(name);}
        return sb.append("\n").toString();}

    private String createEmptyString(int emptyCount) {
        String empty = "";
        for(int i = 0; i < emptyCount; i++){
            empty += " ";
        }
        return empty;
    }

    private String appendRow(int i, ArrayList<ArrayList<String>> ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (int j = 0; j < ladder.get(0).size(); j++) {
            sb.append(ladder.get(i).get(j));
        }
        sb.append("\n");
        return sb.toString();
    }


}
