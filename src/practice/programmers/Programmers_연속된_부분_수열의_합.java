package practice.programmers;

public class Programmers_연속된_부분_수열의_합 {
    public static void main(String[] args) {
        int[] answer1 = solution(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println("answer1 = " + answer1[0] + ", " + answer1[1]);

        int[] answer2 = solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("answer2 = " + answer2[0] + ", " + answer2[1]);
    }

    public static int[] solution(
            int[] sequence,
            int k
    ){
        int left = 0;
        int a = 0;
        int b = 0;
        long sum = 0;
        int len = Integer.MAX_VALUE;

        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left++];
            }

            if(sum == k && right - left + 1 < len){
                a = left;
                b = right;
                len = b - a + 1;
            }
        }

        return new int[]{a, b};
    }
}
