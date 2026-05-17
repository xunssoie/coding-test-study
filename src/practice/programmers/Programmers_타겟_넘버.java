package practice.programmers;

public class Programmers_타겟_넘버 {

    public static void main(String[] args) {
        solution(new int[]{4, 1, 2, 1}, 2);
    }

    static void solution(int[] numbers, int target) {
        int answer = recursive(numbers, 0, 0, target);

        System.out.println("answer = " + answer);
    }

    static int recursive(int[] numbers, int depth, int sum, int target) {
        // 종료 조건
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        // 앞으로의 재귀에서 도출 가능한 답의 범위를 구하기 위해, 남은 값들의 합계를 구한다.
        int remaining = getRemaining(numbers, depth);

        /**
         * 도출 가능한 답의 범위에 target이 위치하는가?
         * NO -> 더 이상 재귀를 반복할 이유가 없음. 종료
         * YES -> 재귀를 반복하는 것이 유의미함. 계속
         */
        if(target > sum + remaining || target < sum - remaining) {
            return 0;
        }
    
        return recursive(numbers, depth+1, sum + numbers[depth], target) +
                recursive(numbers, depth+1, sum - numbers[depth], target);
    }

    static int getRemaining(int[] numbers, int depth){
        int sum = 0;
        for(int i = depth; i<=numbers.length-1; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
