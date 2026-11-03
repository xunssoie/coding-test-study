package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071_평균값_구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < 10; i++){
                int num = Integer.parseInt(st.nextToken());

                sum += num;
            }

            answer.append("#").append(t).append(" ").append(Math.round(sum/10.0)).append("\n");
        }

        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
