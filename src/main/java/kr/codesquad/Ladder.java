package kr.codesquad;

import java.util.Random;

public class Ladder {
    private int width;
    private int length;

    public Ladder(int width, int length) {
        this.width = width+(width-1);
        this.length = length;
    }

    public String[][] createBasicArr (){
        String[][] arr = new String[length][width];
        for(int i = 0; i<length; i++) {
            for(int j = 0 ; j<width; j++) {
                arr[i][j] = (j%2==0?"|":" ");
            }
        }
        randomBar(arr);
        return arr;
    }
    public void randomBar(String [][] arr) {
        String arr2[][] = arr;
        Random random = new Random();
        for(int i = 0; i<length; i++) {
            for (int j =1; j<width; j+=2) {
                    arr[i][j] =(random.nextBoolean()?"-":" ");
            }
        }
    }

    public void printGame(String [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            String[] inArr = arr[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }
    }




}