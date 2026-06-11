package practice.personal;

public class lower_upper_bound_example {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 2, 2, 4, 4, 5}, 2));
        System.out.println(solution(new int[]{1, 3, 5, 7}, 4));
    }

    public static int solution(int[] arr, int x){
        return getUpperBoundIdx(arr, x) - getLowerBoundIdx(arr, x);
    }

    private static int getLowerBoundIdx(int[] arr, int x) {
        int hi = arr.length;
        int low = 0;
        int mid;

        while(low < hi){
            mid = low + (hi-low) / 2;

            if(arr[mid] >= x){
                hi = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private static int getUpperBoundIdx(int[] arr, int x) {
        int hi = arr.length;
        int low = 0;
        int mid;

        while(low < hi){
            mid = low + (hi-low) / 2;

            if(arr[mid] > x){
                hi = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
