package baekjoon.inputoutput;

import java.util.Scanner;

public class BaekJoon_11021 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {

            int a = sc.nextInt();
            int b= sc.nextInt();

            System.out.println("Case #"+(i+1)+": "+ (a+b));
        }
    }
}
