package practice.programmers;

import java.util.Arrays;

public class Programmers_구명_보트 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {70, 50, 80}, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;

        int i = 0;
        int j = people.length - 1;

        while(i <= j){
            if(i == j){
                count++;
                break;
            }

            if(people[i] + people[j] > limit){
                // i번째와 j번째 무게의 합이 limit 보다 큰 경우 j만 태우기
                j--;
            }else{
                // 둘다 태우기
                i++;
                j--;
            }
            count++;
        }
        return count;
    }
}
