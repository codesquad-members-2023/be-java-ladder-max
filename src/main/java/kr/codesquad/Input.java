package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇 명??");
        int num = Integer.parseInt(br.readLine());

        System.out.println("최대 사다리 높이는??");
        int len = Integer.parseInt(br.readLine());

        br.close();

        return new int[]{num, len};
    }
}
