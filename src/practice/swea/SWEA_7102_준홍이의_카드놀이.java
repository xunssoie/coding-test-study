package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7102_준홍이의_카드놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            answer.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] counts = new int[N+M+1];
            for(int n = 1; n <= N; n++){
                for(int m = 1; m <= M; m++){
                    counts[n+m]++;
                }
            }

            int max = counts[0];
            for(int i = 1; i <= N+M; i ++){
                if(counts[i] > max){
                    max = counts[i];
                }
            }

            for(int i = 1; i <= N+M; i++){
                if(counts[i] == max){
                    answer.append(i).append(" ");
                }
            }
            answer.setLength(answer.length()-1);
            answer.append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
