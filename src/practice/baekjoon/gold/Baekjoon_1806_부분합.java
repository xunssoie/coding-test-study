package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1806_부분합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (inRange(i, N) && inRange(j, N)) {
            if(sum < S){
                sum += array[j];
                j++;
            }else{
                if(j - i < min)
                    min = j - i;

                sum -= array[i];
                i++;
            }
        }

        while(i <= j-1 && sum >= S){
            if(j - i < min)
                min = j - i;

            sum -= array[i];
            i++;
        }

        int answer = min == Integer.MAX_VALUE ? 0 : min;

        System.out.print(answer);
    }

    private static boolean inRange(int x, int n) {
        return x >= 0 && x < n;
    }
}
