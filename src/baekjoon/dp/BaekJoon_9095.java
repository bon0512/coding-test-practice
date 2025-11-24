package baekjoon.dp;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class BaekJoon_9095 {

    static int N;
    static int T;
    static int[] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            mem = new int[N + 1];
            mem[1] = 1;
            if (N >= 2) mem[2] = 2;
            if (N >= 3) mem[3] = 4;

            for (int i = 4; i <=N; i++) {
                mem[i] = mem[i-1]+ mem[i-2] + mem[i-3];
            }

            System.out.println(mem[N]);
        }
    }
}
