package practice.personal;

import java.util.Arrays;

public class 두_용액 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{9, -2, -1, 4, 1})));   // [-1, 1]
        System.out.println(Arrays.toString(solution(new int[]{-2, 4, -99, -1, 98}))); // [-99, 98]
    }

    public static int[] solution(int[] solutions) {
        Arrays.sort(solutions);

        int i = 0;
        int j = solutions.length-1;

        int answeri = 0;
        int answerj = 0;
        long k = Long.MAX_VALUE;

        while(i < j){
            long sum = (long)solutions[i] + (long)solutions[j];

            if(Math.abs(sum) < k){
                k = Math.abs(sum);
                answerj = j;
                answeri = i;
            }

            if(sum > 0){
                j--;
            }else if(sum < 0){
                i++;
            }else{
                return new int[]{solutions[i], solutions[j]};
            }
        }
        return new int[]{solutions[answeri], solutions[answerj]};
    }
}
