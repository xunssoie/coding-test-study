package practice.personal;

public class 나무_자르기 {
    public static void main(String[] args) {
        // 기본 예제
        System.out.println(solution(new int[]{20, 15, 10, 17}, 7)
                + " (expected 15)");

        // 경계: 정확히 딱 맞춤 (H=15에서 합 7)
        System.out.println(solution(new int[]{10}, 0)
                + " (expected 10)");   // 하나도 안 잘라도 됨 → H를 나무 높이까지

        // 큰 값: long 오버플로 확인용
        System.out.println(solution(new int[]{1_000_000_000, 1_000_000_000}, 2_000_000_000)
                + " (expected 0)");    // 거의 다 잘라야 함

        // M이 매우 커서 H=0까지 내려야 하는 경우
        System.out.println(solution(new int[]{5, 5, 5}, 15)
                + " (expected 0)");
    }

    public static long solution(
            int[] heights,
            int min
    ){
        long low = 0;
        long high = heights[0];
        for (int height : heights) {
            if(height > high){
                high = height;
            }
        }
        long answer = 0;
        while(low<=high){
            long mid = low + (high - low)/2;

            if(decision(heights, min, mid)){
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return answer;
    }

    public static boolean decision(
            int[] heights,
            int min,
            long H
    ){
        long sum = 0;
        for (int height : heights) {
            sum += Math.max(height-H, 0);
        }

        return sum>=min;
    }
}
