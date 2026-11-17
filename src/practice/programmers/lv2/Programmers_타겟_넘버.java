package practice.programmers.lv2;

public class Programmers_타겟_넘버 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
        System.out.println(solution(new int[]{4,1,2,1}, 4));
    }

    public static int solution(int[] numbers, int target){
        dfs(0, 0, numbers, target);
        return count;
    }

    private static void dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(target == sum)
                count++;
            return;
        }

        dfs(depth+1, sum + numbers[depth], numbers, target);
        dfs(depth+1, sum - numbers[depth], numbers, target);
    }
}
