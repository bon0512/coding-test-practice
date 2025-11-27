package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_4781 {

    static int n;
    static double money;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] price;
        int[] cal;
        int[] mem;

        while (true) {
            n = sc.nextInt();
            money = sc.nextDouble();
            int M = (int) (money * 100 + 0.5);
            if (n == 0 && money == 0.00) break;

            price = new int[n];
            cal = new int[n];
            mem = new int[M + 1];

            for (int i = 0; i < n; i++) {
                cal[i] = sc.nextInt();
                price[i] = (int) (sc.nextDouble() * 100 + 0.5);
            }

            for (int i = 0; i < n; i++) {
                for (int m = price[i]; m <= M; m++) {
                    mem[m] = Math.max(mem[m], mem[m - price[i]] + cal[i]);
                }
            }

            System.out.println(mem[M]);
        }
    }


}
