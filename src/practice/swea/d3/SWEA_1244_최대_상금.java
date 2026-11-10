package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1244_최대_상금 {

    static char[] numbers;
    static int n;
    static int k;
    static int max;

    static boolean[][] visited = new boolean[11][1000000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            numbers = st.nextToken().toCharArray();
            n = numbers.length;
            k = Integer.parseInt(st.nextToken());
            max = 0;

            for(int d = 0; d <= k; d++)
                Arrays.fill(visited[d], false);

            dfs(0);
            answer.append("#").append(t).append(" ").append(max).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static void dfs(int depth){
        int cur = toInt(numbers);

        if(visited[depth][cur])
            return;

        visited[depth][cur] = true;

        if(depth == k){
            max = Math.max(max, cur);
            return;
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                swap(i, j);
                dfs(depth+1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    static int toInt(char[] arr) {
        int v = 0;
        for (char c : arr) {
            v = v * 10 + (c - '0');
        }
        return v;
    }
}
