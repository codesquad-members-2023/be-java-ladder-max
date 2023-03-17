package kr.codesquad;

import java.util.Random;

public class Ladder {
    private int width;
    private int length;

    public Ladder(int width, int length) {
        this.width = width+(width-1);
        this.length = length;
    }

    private String[][] createBasicArr (){
        String[][] arr = new String[length][width];
        for(int i = 0; i<length; i++) {
            createStick(arr,i);
        }
        randomBar(arr);
        return arr;
    }
    private void randomBar(String [][] arr) {
        for(int i = 0; i<length; i++) {
            createRandomBar(arr,i);
        }
    }

    private void createStick(String[][] arr,int i){
            for(int j = 0 ; j<width; j++) {
                arr[i][j] = (j%2==0?"|":" ");
        }
    }

    private void createRandomBar(String[][] arr,int i){
        Random random = new Random();
        for (int j =1; j<width; j+=2) {
            arr[i][j] =(random.nextBoolean()?"-":" ");
        }

    }

    public void printGame() {
        String[][] arr = createBasicArr();
        for (int i = 0; i < arr.length; i++) {
            String[] inArr = arr[i];
            printArrFlat(inArr);
            System.out.println();
        }
    }

    private void printArrFlat (String inArr[]) {
        for (int j = 0; j < inArr.length; j++) {
            System.out.print(inArr[j] + " ");
        }
    }




}