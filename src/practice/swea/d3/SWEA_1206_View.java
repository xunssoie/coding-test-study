package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206_View {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] buildings = new int[N];
            for(int i = 0; i < N; i++){
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for(int i = 0; i < N; i++){
                int a, b, c, d;

                if(i-2 < 0){
                    a = 0;
                }else{
                    a = buildings[i-2];
                }

                if(i-1 < 0){
                    b = 0;
                }else{
                    b = buildings[i-1];
                }

                if(i+1 > N-1){
                    c = 0;
                }else{
                    c = buildings[i+1];
                }

                if(i+2 > N-1){
                    d = 0;
                }else{
                    d = buildings[i+2];
                }

                int max = Math.max(Math.max(a, b), Math.max(c, d));

                if(buildings[i] > max){
                    sum += buildings[i] - max;
                }
            }
            answer.append("#").append(t).append(" ").append(sum).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}