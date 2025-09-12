package baekjoon.inputoutput;

import java.util.Scanner;

public class BaekJoon_1000 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i =0 ; i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[i] = a+b;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
