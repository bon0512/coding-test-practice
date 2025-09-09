package baekjoon.dfs;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_3040 {

    static int total;
    static int[] input = new int[2];
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 9; i++) {
            int temp = sc.nextInt();
            arr.add(temp);
            total += temp;
        }

        combination(0, 0, total - 100);


    }

    private static void combination(int start, int depth, int diff) {
        if (depth == 2) {
            int tempTotal = input[0]+input[1];
            if (tempTotal == diff) {
                arr.remove(Integer.valueOf(input[0]));
                arr.remove(Integer.valueOf(input[1]));

                for (Integer integer : arr) {
                    System.out.println(integer);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            input[depth] = arr.get(i);
            combination(start+1,depth+1,diff);
        }

    }
}
