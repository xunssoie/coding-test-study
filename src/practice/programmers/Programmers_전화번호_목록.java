package practice.programmers;

import java.util.Arrays;

public class Programmers_전화번호_목록 {
    public static void main(String[] args) {
        String[] t1 = {"119", "97674223", "1195524421"};
        String[] t2 = {"123", "456", "789"};
        String[] t3 = {"12", "123", "1235", "567", "88"};

        System.out.println(solution(t1));
        System.out.println(solution(t2));
        System.out.println(solution(t3));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++){
             String cur = phone_book[i];
             String next = phone_book[i+1];

             if(next.startsWith(cur))
                 return false;
        }

        return true;
    }
}
