package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209_Sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            br.readLine();

            int[][] array = new int[100][100];
            for(int i = 0; i < 100; i++){
                StringTokenizer row = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    array[i][j] = Integer.parseInt(row.nextToken());
                }
            }

            int max = 0;
            for(int i = 0; i < 100; i++){
                int sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += array[i][j];
                }

                if(sum > max)
                    max = sum;
            }

            for(int i = 0; i < 100; i++){
                int sum = 0;
                for(int j = 0; j< 100; j++){
                    sum += array[j][i];
                }

                if(sum > max)
                    max = sum;
            }

            int sum = 0;
            for(int i = 0; i < 100; i++){
                sum += array[i][i];
            }

            if(sum > max)
                max = sum;

            sum = 0;
            for(int i = 0; i < 100; i++){
                sum += array[i][99-i];
            }

            if(sum > max)
                max = sum;

            answer.append("#").append(t).append(" ").append(max).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
