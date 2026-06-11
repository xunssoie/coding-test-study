package practice.programmers;

public class Programmers_입국_심사{
    public static void main(String[] args) {
        System.out.println("solution = " + solution(6, new int[]{7,10}));
    }

    public static long solution(int n, int[] times){
        int max = times[0];
        for (int time : times) {
            if (time > max) {
                max = time;
            }
        }

        long low = 0;
        long high = (long) max * n;

        while(low < high){
            long mid = low + (high - low) / 2;

            if(canFinish(n, mid, times)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canFinish(int n, long t, int[] times){
        long handleableTotal = 0;
        for (int time : times) {
            handleableTotal += t / time;
        }

        if (handleableTotal >= n){
            return true;
        }else{
            return false;
        }
    }
}
