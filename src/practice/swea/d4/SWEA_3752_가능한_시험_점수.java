package practice.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_3752_가능한_시험_점수 {

    static Set<Integer> possibleScore;
    static int N;
    static int[] scores;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            scores = new int[N];
            possibleScore = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < N; i++){
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }

            visited = new boolean[N+1][sum+1];

            dfs(0, 0);
            answer.append("#").append(t).append(" ").append(possibleScore.size()).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static void dfs(int depth, int score){
        if(depth == N){
            possibleScore.add(score);
            return;
        }

        if(!visited[depth +1][score + scores[depth]]){
            visited[depth +1][score + scores[depth]] = true;
            dfs(depth +1, score + scores[depth]);
        }

        if(!visited[depth +1][score]){
            visited[depth +1][score] = true;
            dfs(depth +1, score);
        }
    }
}
