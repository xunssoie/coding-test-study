package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959_두_개의_숫자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] la = new int[a];
            int[] lb = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                la[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                lb[i] = Integer.parseInt(st.nextToken());
            }

            if (a == b) {
                int sum = 0;
                for (int i = 0; i < a; i++) {
                    sum += la[i] * lb[i];
                }
                answer.append("#").append(t).append(" ").append(sum).append("\n");
                continue;
            }

            if(a<b){
                int max = 0;
                for (int i = 0; i < b - a + 1; i++) {
                    int sum = 0;
                    for (int j = 0; j < a; j++) {
                        sum += la[j] * lb[j+i];
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
                answer.append("#").append(t).append(" ").append(max).append("\n");
                continue;
            }

            int max = 0;
            for (int i = 0; i < a - b + 1; i++) {
                int sum = 0;
                for (int j = 0; j < b; j++) {
                    sum += lb[j] * la[j+i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
            answer.append("#").append(t).append(" ").append(max).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
