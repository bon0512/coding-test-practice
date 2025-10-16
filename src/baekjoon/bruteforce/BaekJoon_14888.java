package baekjoon.bruteforce;

import java.util.*;

public class BaekJoon_14888 {

    static int N;
    static int[] num;
    static int[] op;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        num = new int[N];
        op = new int[4];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < op.length; i++) {
            op[i] = sc.nextInt();
        }


        dfs(num[0], 1);
        //System.out.println(answer);

        System.out.println(max);
        System.out.println(min);


    }

    private static void dfs(int current, int depth) {

        if (depth == N) {

            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        int next = num[depth];

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                int newVal = 0;
                if (i == 0) newVal = current + next;
                else if (i == 1) newVal = current - next;
                else if (i == 2) newVal = current * next;
                else newVal = divideTruncTowardZero(current, next);

                dfs(newVal,depth+1);
                op[i]++;
            }
        }


    }

    private static int divideTruncTowardZero(int a, int b) {
        int res = Math.abs(a) / Math.abs(b);
        if ((a < 0) ^ (b < 0)) res = -res;
        return res;
    }
}
