package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_11399 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr=  new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[] sum = new int[n];

        sum[0] = arr[0];

        int answer = sum[0];

        for (int i = 1; i <n; i++) {
            sum[i] = sum[i-1]+arr[i];
            answer += sum[i];
        }
        System.out.println(answer);
    }
}
