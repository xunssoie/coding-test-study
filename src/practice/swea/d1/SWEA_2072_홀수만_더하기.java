package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2072_홀수만_더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < 10; i++){
                int num = Integer.parseInt(st.nextToken());

                if(num % 2 == 1){
                    sum += num;
                }
            }

            answer.append("#").append(t).append(" ").append(sum).append("\n");
        }

        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
