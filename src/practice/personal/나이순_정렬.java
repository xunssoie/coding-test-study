package practice.personal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 나이순_정렬 {
    public static void main(String[] args) {

    }

    public static List<Member> solution(Object[][] members){
        List<Member> memberList = new ArrayList<>();
        int i = 0;
        for (Object[] member : members) {
            memberList.add(new Member(i++, (Integer) member[0], (String) member[1]));
        }

        memberList.sort(
                Comparator.comparingInt(Member::getAge)
                        .thenComparingInt(Member::getOrder)
        );

        return memberList;
    }

    static class Member{
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
