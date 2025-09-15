package baekjoon.implementation;

import java.util.Enumeration;
import java.util.Scanner;

/**
 * 베르트랑 공준
 *
 */

public class BaekJoon_4948 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            int n = sc.nextInt();
            if(n==0) break;

            int count  = 0;
            for (int i = n+1; i <= n*2; i++) {
                if(isPrime(i)){
                    count++;
                }
            }
            System.out.println(count);

        }

    }

    public static boolean isPrime(int num){

        for (int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
