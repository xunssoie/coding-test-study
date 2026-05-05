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
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int remaining = getRemaining(numbers, depth);

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
