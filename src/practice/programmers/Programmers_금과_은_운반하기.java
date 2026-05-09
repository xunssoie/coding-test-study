package practice.programmers;

public class Programmers_금과_은_운반하기 {
    public static void main(String[] args) {
        System.out.println("solution = " + solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10}));
    }

    // T 시간 안에 운반 가능 여부는 단조성 → 가능한 최소 T를 이분탐색
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long low = 1;
        long high = (long) (5 * Math.pow(10, 14));

        long answer = 0;
        while(low < high){
            long mid = low + (high - low) / 2;

            if(canMove(a, b, g, s, w, t, mid)){
                high = mid;
                answer = mid;
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }

    // mid 시간 안에 a, b 운반 가능?
    // 조건 3가지 모두 만족해야 가능 (3번이 트럭 용량 한계 검증)
    public static boolean canMove(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid) {
        long totalGold = 0, totalSilver = 0, totalAny = 0;

        for(int i = 0; i < t.length; i++){
            // n번째 운반 완료 = (2n-1)*t[i] ≤ mid
            long trips = (mid + t[i]) / (2L * t[i]);
            long capacity = w[i] * trips;

            // 트럭 용량과 도시 보유량 중 작은 쪽이 실제 운반량
            totalGold   += Math.min(capacity, g[i]);
            totalSilver += Math.min(capacity, s[i]);
            totalAny    += Math.min(capacity, g[i] + s[i]);
        }

        return totalGold >= a                // 1) 금 충족
                && totalSilver >= b          // 2) 은 충족
                && totalAny >= a + b;        // 3) 총량(트럭 용량 한계) 충족
    }
}