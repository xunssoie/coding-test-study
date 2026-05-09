package practice.programmers;

import java.util.Arrays;

public class Programmers_징검_다리 {
    public static void main(String[] args) {
        System.out.println("solution = " + solution(25, new int[]{2, 14, 11, 21, 17}, 5));
    }

    public static int solution(int distance, int[] rocks, int n){

        if(rocks.length == n){
            return distance;
        }

        int answer = 0;
        int low = 1;
        int high = distance;

        Arrays.sort(rocks);

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canRemove(rocks, distance, n, mid)){
                low = mid + 1;
                answer = mid;
            }else{
                high = mid;
            }
        }
        return answer;
    }

    public static boolean canRemove(int[] rocks, int distance, int n, int mid){
        int prev = 0;
        int removed = 0;

        for (int rock : rocks) {
            if(rock - prev < mid){
                removed++;
            }else{
                prev = rock;
            }
        }

        if(distance - prev < mid){
            removed++;
        }

        return removed <= n;
    }
}
