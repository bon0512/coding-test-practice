package baekjoon.dp;

import java.util.Scanner;

public class BaekJoon_1463_dp {

    static int[] mem;
    static int X;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        mem = new int[X+1];

        mem[1] = 0;
        if (X >= 2) mem[2] = 1;
        if (X >= 3) mem[3] = 1;

        for (int i =4; i <=X; i++) {

            int a  = 100000;
            int b = 100000;
            int c = 100000;
            if(i%3==0){
                a = mem[i/3]+1;
            }
            if(i%2 ==0){
                b = mem[i/2]+1;
            }
            c = mem[i-1]+1;
            a = Math.min(a,b);
            mem[i] = Math.min(a,c);
        }

        System.out.println(mem[X]);
    }
}
