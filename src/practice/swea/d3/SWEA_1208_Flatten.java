package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            int dump = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] heights = new int[100];
            for(int i = 0; i < 100; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < dump; i++){
                Arrays.sort(heights);

                if(heights[0] == heights[99])
                    break;

                heights[0]++;
                heights[99]--;
            }
            Arrays.sort(heights);
            answer.append("#").append(t).append(" ").append(heights[99]-heights[0]).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}