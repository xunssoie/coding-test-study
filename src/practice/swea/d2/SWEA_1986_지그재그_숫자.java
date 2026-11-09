package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1986_지그재그_숫자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            for(int n = 1; n <= N; n++){
                if(n%2 == 1){
                    sum += n;
                }else{
                    sum -= n;
                }
            }

            answer.append("#").append(t).append(" ").append(sum).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
