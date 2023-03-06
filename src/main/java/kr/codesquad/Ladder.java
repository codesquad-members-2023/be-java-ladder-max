package kr.codesquad;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {

        int[] num = input();
        char[][] chArr = makeLadder(num[1],num[0]);
        printLadder(chArr);
    }
    static int[] input(){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[2];
        System.out.println("참여할 사람은 몇 명인가요?");
        num[0] = (scanner.nextInt()*2)-1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        num[1] = scanner.nextInt();
        return num;
    }

    static char[][] makeLadder(int row, int column){
        char[][] ladder = new char[row][column];

        for (int i=0;i<row;i++){
            Arrays.fill(ladder[i],'|');
            for (int j=1;j<column;j+=2){
                Random random = new Random();
                ladder[i][j] = random.nextInt(2) == 0 ? '-' : ' ';
            }
        }
        return  ladder;
    }
    static void printLadder(char[][] ladder){
        for (char[] ch : ladder){
            System.out.println(ch);
        }
    }
}
