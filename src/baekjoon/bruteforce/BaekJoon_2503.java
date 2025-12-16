package baekjoon.bruteforce;

import java.util.*;

public class BaekJoon_2503 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        List<String> allList = new ArrayList<>();
        for (int i = 111; i <= 999; i++) {
            String s = i + "";
            if (s.contains("0")) continue;
            char a = s.charAt(0);
            char b = s.charAt(1);
            char c = s.charAt(2);

            if (a == b || b == c || c == a) continue;
            allList.add(s);
        }


        //정답 후보들을 갖고온다.

        while (N-- > 0) {
         List<String> answer = new ArrayList<>();
            String number = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();

            char first = number.charAt(0);
            char second = number.charAt(1);
            char third = number.charAt(2);

            for (int i = 0; i < allList.size(); i++) {
                String s = allList.get(i);
                char a = s.charAt(0);
                char b = s.charAt(1);
                char c = s.charAt(2);

                int strikeCount = 0;
                int ballCount = 0;

                //스트라이크 존 카운트
                if (first == a) strikeCount++;
                if (second == b) strikeCount++;
                if (third == c) strikeCount++;

                //볼 카운트

                if (first == b || first == c) ballCount++;
                if (second == a || second == c) ballCount++;
                if (third == b || third == a) ballCount++;

                if (strikeCount == strike && ballCount == ball) {
                    answer.add(s);
                }

            }
            allList = answer;
        }

        System.out.println(allList.size());
    }
}
