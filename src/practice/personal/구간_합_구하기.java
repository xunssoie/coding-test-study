package practice.personal;

import java.util.Arrays;

public class 구간_합_구하기 {
    public static void main(String[] args) {
        // 예제 1
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[][] queries1 = {{0, 2}, {1, 3}, {0, 4}};
        System.out.println(Arrays.toString(solution(numbers1, queries1))); // 기대: [6, 9, 15]

        // 예제 2
        int[] numbers2 = {5, -3, 2, 7, -1};
        int[][] queries2 = {{0, 0}, {1, 4}};
        System.out.println(Arrays.toString(solution(numbers2, queries2))); // 기대: [5, 5]
    }

    public static long[] solution(
            int[] numbers,
            int[][] queries
    ){
        long[] prefix = new long[numbers.length+1];
        prefix[0] = 0L;

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i-1];
        }

        long[] answer = new long[queries.length];
        int i = 0;
        for (int[] query : queries) {
            answer[i] = prefix[query[1]+1] - prefix[query[0]];
            i++;
        }

        return answer;
    }
}
