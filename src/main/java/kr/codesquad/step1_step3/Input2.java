package kr.codesquad.step1_step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input2 {

    public static int ladderLength() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return  Integer.parseInt(bufferedReader.readLine());
    }

    public static String insertUser() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String result = bufferedReader.readLine();
        String[] arr = result.split(",");
//        for(String temp : arr){
//            System.out.println(temp);
//            if(temp.length()>5) {
//                System.out.println("이름은 다섯글자 까지 가능 다시입력 :");
//                result = bufferedReader.readLine();
//                break;
//            }
//        }

        return range(arr,result);
    }

    public static String range(String[] arr,String re) throws IOException {
        String result = re;
        for(String temp : arr){
            System.out.println(temp);
            if(temp.length()>5){
                return insertUser();
            }
        }
        return result;
    }
//    public static String checkRange(String temp,String re) throws IOException {
//        String result = re;
//        if(temp.length()>5){
//            throw new RuntimeException();
//        }
//        return result;
//    }

}
