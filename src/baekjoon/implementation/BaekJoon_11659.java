package baekjoon.implementation;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 구간 합 구하기 4
 * <a href="https://www.acmicpc.net/problem/11659">...</a>
 */

public class BaekJoon_11659 {

    static int N,M;
    static int[] array;
    static int[] nu;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        nu = new int[N+1];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            nu[i] = nu[i - 1] + array[i-1];
        }

        //System.out.println(Arrays.toString(nu));

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int answer = nu[end] - nu[start - 1];
            System.out.println(answer);
        }

    }

}
