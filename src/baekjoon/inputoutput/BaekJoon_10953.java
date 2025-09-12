package baekjoon.inputoutput;

import java.util.Scanner;

public class BaekJoon_10953 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            int a= s.charAt(0) -'0';
            int b = s.charAt(2) - '0';
            System.out.println(a+b);
        }
    }
}
