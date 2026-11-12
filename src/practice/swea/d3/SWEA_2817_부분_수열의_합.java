package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817_부분_수열의_합 {

    static int[] array;
    static int N;
    static int K;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 0;
            array = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            answer.append("#").append(t).append(" ").append(count).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static void dfs(int idx, int sum){
        if(sum > K)
            return;

        if(idx == N){
            if(sum == K){
                count++;
            }
            return;
        }

        dfs(idx+1, sum);
        dfs(idx+1, sum + array[idx]);
    }
}
