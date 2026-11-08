package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1970_쉬운_거스름돈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int rest = Integer.parseInt(br.readLine().trim());

            answer.append("#").append(t).append("\n");
            for(int m : money){
                answer.append(rest / m).append(" ");
                rest %= m;
            }
            answer.setLength(answer.length() - 1);
            answer.append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
