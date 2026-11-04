package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204_최빈수_구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int[] scores = new int[101];

            int x = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                scores[Integer.parseInt(st.nextToken())]++;
            }

            int score = 0;
            int times = 0;
            for(int i = 1; i < 101; i++){
                if(scores[i] >= times){
                    times = scores[i];
                    score = i;
                }
            }

            answer.append("#").append(t).append(" ").append(score).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
