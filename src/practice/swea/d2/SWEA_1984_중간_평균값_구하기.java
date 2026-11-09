package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984_중간_평균값_구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            double[] array = new double[10];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++){
                array[i] = Double.parseDouble(st.nextToken());
            }

            Arrays.sort(array);

            double sum = 0.0;
            for(int i = 1; i < 9; i++){
                sum += array[i];
            }

            answer.append("#").append(t).append(" ").append(Math.round(sum/8.0)).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
