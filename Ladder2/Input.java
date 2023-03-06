package Ladder2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Input {

    public static void takeInput() throws IOException {
        //입력 변경
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        //takeNames 메소드 생성 및 구현
        ArrayList<String> pplNames = takeNames();
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        int ladderHeight = takeInt();
        createLadder(pplNames, ladderHeight);
    }

    private static ArrayList<String> takeNames() throws IOException {
        ArrayList<String> names = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        while(st.hasMoreTokens()){
            names.add(st.nextToken());
        }

        return names;
    }

    private static void createLadder(int pplNumber, int ladderHeight) {
        Ladder ladder = new Ladder(pplNumber, ladderHeight);
    }

    private static int takeInt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
