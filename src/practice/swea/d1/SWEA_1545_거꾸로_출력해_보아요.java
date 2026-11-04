package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1545_거꾸로_출력해_보아요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(;N >= 0; N--)
            answer.append(N).append(" ");

        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
