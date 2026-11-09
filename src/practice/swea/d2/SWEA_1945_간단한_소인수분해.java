package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1945_간단한_소인수분해 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        int[] d = {2,3,5,7,11};

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int[] subAnswers = {0,0,0,0,0};

            int x = Integer.parseInt(br.readLine().trim());

            for(int i = 0; i < 5; i++){
                while(x % d[i] == 0){
                    x /= d[i];
                    subAnswers[i]++;
                }
            }

            answer.append("#").append(t).append(" ");
            for (int subAnswer : subAnswers) {
                answer.append(subAnswer).append(" ");
            }
            answer.setLength(answer.length()-1);
            answer.append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
