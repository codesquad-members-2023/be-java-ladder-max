package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private List<List<String>> radder = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public Ladder(String nameData, int height){
        String[] nameArr = nameData.split(",");
        for(String name : nameArr){
            names.add(name);
        }
        this.height = height;
    }

    public void createRadder() {
        for(int i=0; i<height; i++){
            radder.add(createRow());
        }
    }

    public List<String> createRow() {
        List<String> row = new ArrayList<>();
        for(int i=0; i<names.size()-1; i++){
            row.add(getRandomLine());
        }
        return row;
    }

    public String getRandomLine() {
        int random = (int)(Math.random()*2);
        if(random == 1) {
            return "-----";
        }
        return "     ";
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeNameRow() + "\n");
        for(int i=0; i<height; i++){
            sb.append(makeRowString(radder.get(i)));
            sb.append("\n");
        }
        System.out.println(sb);
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

    public String makeRowString(List<String> row) {
        String oneRow = "  |";
        for(int i=0; i<row.size(); i++){
            oneRow += row.get(i) + "|";
        }
        return oneRow;
    }
}
