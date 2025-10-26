package baekjoon.dp;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class BaekJoon_9655 {


    static int N;
    static boolean[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new boolean[N + 1];

        arr[0] = false;
        for (int i = 0; i <= N; i++) {
            arr[i] = false;
            if (i - 1 >= 0 && !arr[i - 1]) arr[i] = true;
            if (i - 3 >= 0 && !arr[i - 3]) arr[i] = true;
        }

        System.out.println(arr[N] ? "SK":"CY");
    }
}
