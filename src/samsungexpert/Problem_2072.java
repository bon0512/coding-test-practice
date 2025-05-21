package samsungexpert;

import java.util.*;
public class Problem_2072 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.nextLine(); // 문자열 입력
            int answer = 0;

            // 마디 길이 1부터 10까지 시도
            for(int i =1;i<s.length();i++){
                String str1 = s.substring(0,i);
                String str2 = s.substring(i,i+i);

                if(str1.equals(str2)){
                    System.out.println("#"+test_case+" "+str1.length());
                }
            }


        }


    }
}
