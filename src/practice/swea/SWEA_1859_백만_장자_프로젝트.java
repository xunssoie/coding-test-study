package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1859_백만_장자_프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());

            List<Integer> predicated = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                predicated.add(Integer.parseInt(st.nextToken()));
            }

            long profit = 0;
            int max = predicated.get(predicated.size()-1);

            for(int i = predicated.size()-1; i >= 0; i--){
                if(predicated.get(i)>max){
                    max = predicated.get(i);
                    continue;
                }

                profit += max - predicated.get(i);
            }

            sb.append("#").append(t+1).append(" ").append(profit).append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
    }
}
