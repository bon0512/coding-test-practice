package baekjoon.bruteforce;

import java.util.Scanner;

public class BaekJoon_10819 {

    static int N;
    static int[] arr;
    static boolean[] back;
    static int max=-1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        back = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        per(0,new int[N]);
        System.out.println(max);


    }

    private static void per(int depth, int[] temp) {

        if(depth == N){
            int sum = 0;
            for (int i = 0; i < temp.length-1; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            max = Math.max(sum,max);
            return;
        }

        for (int i = 0; i < temp.length; i++) {

            if(!back[i]){
                back[i] =true;
                temp[depth] = arr[i];
                per(depth+1,temp);
                back[i] =false;
            }

        }


    }
}
