package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_1037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int i : arr) {
            max = Math.max(max,i);
            mn = Math.min(mn,i);
        }


        System.out.println(max*mn);
    }
}
