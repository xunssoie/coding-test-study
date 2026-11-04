package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1936_1대1_가위바위보 {
    public static void main(String[] args) throws Exception {
        // 가위 = 1, 바위 = 2, 보 = 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A == 1){
            if(B == 2){
                System.out.print("B");
            }else{
                System.out.print("A");
            }
        }else if(A == 2){
            if(B == 1){
                System.out.print("A");
            }else{
                System.out.print("B");
            }
        }else{
            if(B == 1){
                System.out.print("B");
            }else{
                System.out.print("A");
            }
        }
    }
}
