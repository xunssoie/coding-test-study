package practice.swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10507_영어_공부 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int[] inputs = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                inputs[i] = num;
            }

            int max = 0;
            for (int input : inputs) {
                if(input > max){
                    max = input;
                }
            }

            int[] days = new int[max + P + 1];

            for (int input : inputs) {
                days[input] = 1;
            }

            int left = 0;
            int used = 0;
            int maxLen = 0;

            for(int right = 0; right < days.length; right++){
                // 1. right 칸을 구간에 넣기
                if(days[right] == 0){
                    used++;
                }

                // 2. 쓴 p가 P를 넘으면 left 당기기 (빈칸이 빠지면 p 돌려받기)
                while(used > P){
                    if(days[left] == 0){
                        used--;
                    }
                    left++;
                }

                // 3. 답 갱신
                int len = right - left + 1;
                if(len > maxLen){
                    maxLen = len;
                }
            }

            answer.append("#").append(t).append(" ").append(maxLen).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
