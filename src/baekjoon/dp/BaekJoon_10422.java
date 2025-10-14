package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_10422 {

    static int T;
    static int L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        //System.out.println("테스트");
        long[] count = new long[5001];
        count[0]=1;
        count[2]=1;
        count[4]=2;

        for (int i = 0; i < count.length; i++) {
            if(i%2==1) count[i]=0;
        }
        for (int i = 6; i <count.length ; i+=2) {
            for (int j = 0; j <i; j+=2) {
                count[i] += (count[j]*count[i-j-2]);
                count[i] %= 1_000_000_007;
            }

        }
        //System.out.println(Arrays.toString(count));

        while(T-->0){
            L = sc.nextInt();

            System.out.println(count[L]);
        }
    }
}
