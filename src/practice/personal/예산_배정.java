package practice.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 예산_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> requirements = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            requirements.add(Integer.parseInt(st.nextToken()));
        }

        int totalMoney = Integer.parseInt(br.readLine());

        int low = 0;
        int high = requirements.get(0);
        for (Integer requirement : requirements) {
            if(requirement >= high)
                high = requirement;
        }

        int answer = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(decision(requirements, mid, totalMoney)){
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        System.out.print(answer);
    }

    public static boolean decision(
            List<Integer> requirements,
            int mid,
            int totalMoney
    ){
        long sum = 0;
        for (Integer requirement : requirements) {
            sum += Math.min(mid, requirement);
        }
        return sum <= totalMoney;
    }
}
