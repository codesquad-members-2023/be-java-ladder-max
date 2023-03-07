package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private List<List<Character>> radder = new ArrayList<>();

    private List<String> names = new ArrayList<>();

    public void createRadder(String inputNameData, int height) {
        String[] nameArr = inputNameData.split(",");
        for(String name : nameArr){
            names.add(name);
        }
        this.height = height;

        for(int i=0; i<height; i++){
            radder.add(createRow());
        }
    }

    public List<Character> createRow() {
        int width = names.size();
        List<Character> row = new ArrayList<>();
        for(int i=0; i<width-1; i++){
            row.add(getRandomLine());
        }
        return row;
    }

    public char getRandomLine() {
        int random = (int)(Math.random()*2);
        if(random == 1) {
            return '-';
        }
        return ' ';
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<height; i++){
            sb.append(makeRowString(radder.get(i)));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String makeRowString(List<Character> row) {
        String oneRow = "|";
        for(int i=0; i<row.size(); i++){
            oneRow += row.get(i) + "|";
        }
        return oneRow;
    }
}
