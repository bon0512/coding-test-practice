package baekjoon.bruteforce;

import java.util.*;

/**
 * N과 M 9
 *
 */

public class BaekJoon_15663 {



    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);



        per(0, new int[M]);


    }

    private static void per(int depth, int[] temp) {

        if (depth == M) {

            for (int j : temp) {
                System.out.print(j + " ");
            }
            System.out.println();

            return;


        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && prev !=arr[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                per(depth + 1, temp);
                visited[i] = false;
                prev = arr[i];
            }

        }

    }
}
