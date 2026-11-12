package practice.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer row = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(row.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0 && isRemovable(i ,j)){
                        map[i][j] = 0;
                    }
                }
            }

            int sum = 0;
            for(int i = 0; i < N; i++){
                sum += countDeadlocks(i);
            }

            answer.append("#").append(t).append(" ").append(sum).append("\n");
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static boolean isRemovable(int i, int j){
        int target = map[i][j];

        if(target == 1){
            for(int k = i; k < N; k++){
                if (map[k][j] == 2)
                    return false;
            }
            return true;
        }else{
            for(int k = i; k >= 0; k--){
                if(map[k][j] == 1)
                    return false;
            }
        }

        return true;
    }

    static int countDeadlocks(int col){
        List<Integer> list = convertColToList(col);
        Stack<Integer> stack = new Stack<>();

        if(list.isEmpty()){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int target = list.get(i);

            if(stack.isEmpty()){
                stack.push(target);
            }else if(stack.peek() != target){
                if(stack.peek() == 1 && target == 2)
                    count++;
                stack.pop();
                stack.push(target);
            }
        }

        return count;
    }

    static List<Integer> convertColToList(int col){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            if(map[i][col] != 0){
                list.add(map[i][col]);
            }
        }

        return list;
    }
}
