package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1288_새로운_불면증_치료법 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int cN = N;
            boolean[] exists = new boolean[10];

            int time = 1;
            while(!isAllExists(exists)){
                String sN = String.valueOf(cN);

                for(int i = 0; i < sN.length(); i++){
                    exists[Integer.parseInt(String.valueOf(sN.charAt(i)))] = true;
                }

                time++;
                cN = N * time;
            }

            answer.append("#").append(t).append(" ").append((time-1)*N).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    private static boolean isAllExists(boolean[] exists){
        for (boolean exist : exists) {
            if(!exist)
                return false;
        }
        return true;
    }
}
