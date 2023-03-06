package kr.codesquad;

import java.util.Random;

public class Ladder {
    private String [][] laddder;

    Ladder(int n, int m){
        laddder = new String[2*m-1][n];

    }
    void makeLadderMap(){

        for(int i=0; i<laddder.length; i++){
            for(int j=0; j<laddder[i].length; j++){
                if(j%2==1){
                    laddder[i][j]= "|";
                }
                    laddder[i][j] =" ";
            }
        }
    }

    void showTotalLadder(){

        for(int i=0 ; i<laddder.length; i++){
            for(int j= 0; j<laddder[i].length; j++){
                System.out.print(laddder[i][j]);
            }
            System.out.println();
        }
    }

    void makeRandomLadderLine(){
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        // if -> True라면
        if(randomBoolean){

        }
    }
    void printLadder(){
        System.out.println(laddder);
    }

}
