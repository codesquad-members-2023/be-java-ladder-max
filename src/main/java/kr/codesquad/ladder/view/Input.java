package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static int ladderLength() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return  Integer.parseInt(bufferedReader.readLine());
    }

    public  String insertUser() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String result = bufferedReader.readLine();
        String[] arr = result.split(",");
        return range(arr,result);
    }
    public  String range(String[] arr,String re) throws IOException {
        for(String temp : arr){
            if(temp.length()>5){
                return insertUser();
            }
        }
        return re;
    }

}
