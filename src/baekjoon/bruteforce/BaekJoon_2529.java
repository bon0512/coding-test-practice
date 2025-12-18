package baekjoon.bruteforce;

import java.util.Scanner;

public class BaekJoon_2529 {

    static int k;
    static char[] c;
    static int[] number = new int[10];
    static long maxAnswer = Long.MIN_VALUE;
    static long minAnswer = Long.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        c = new char[k];

        for (int i = 0; i < k; i++) {
            c[i] = sc.next().charAt(0);
        }


        for (int i = 0; i < 10; i++) {
            number[i] = 1;
        }


        for (int i = 0; i < 10; i++) {
            number[i] = 0;
            dfs(i, i + "", 0);
            number[i] = 1;
        }


        System.out.println(maxAnswer + "");

        StringBuilder temp = new StringBuilder(String.valueOf(minAnswer));

        while (temp.length() < k + 1) {
            temp.insert(0, "0");
        }
        System.out.println(temp.toString());


    }

    private static void dfs(int start, String temp, int seq) {

        if (temp.length() == k + 1) {
            long numberInt = Long.parseLong(temp);
            //System.out.println(numberInt);
            maxAnswer = Math.max(maxAnswer, numberInt);
            minAnswer = Math.min(minAnswer, numberInt);

            return;
        }


        for (int i = 0; i < 10; i++) {
            if (number[i] != 1) continue;
            char munza = c[seq];

            if (munza == '>') {
                if (start > i) {
                    number[i] = 0;
                    dfs(i, temp + i, seq + 1);
                    number[i] = 1;
                }
            } else if (munza == '<') {
                if (start < i) {
                    number[i] = 0;
                    dfs(i, temp + i, seq + 1);
                    number[i] = 1;
                }
            }

        }


    }

}
