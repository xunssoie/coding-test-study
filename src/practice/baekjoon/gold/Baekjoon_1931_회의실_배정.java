package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_1931_회의실_배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            meetings[i][0] = startTime;
            meetings[i][1] = endTime;
        }

        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));

        int answer = 1;
        int startTime = meetings[0][0];
        int endTime = meetings[0][1];
        for (int i = 1; i < N; i++) {
            int a = meetings[i][0];
            int b = meetings[i][1];

            if (a < endTime)
                continue;

            startTime = a;
            endTime = b;

            answer++;
        }

        System.out.print(answer);
    }
}
