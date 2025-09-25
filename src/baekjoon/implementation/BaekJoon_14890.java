package baekjoon.implementation;

import java.util.*;

public class BaekJoon_14890 {

    static int L = 2;
    static boolean[] isLadder;
    static int N;
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N][N];




        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {

            if(check(arr[i])) {
                System.out.println(Arrays.toString(arr[i]));
                count++;
            }
        }

        System.out.println("==세로===");
        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            for (int j = 0; j < N; j++) {
                temp[j] = arr[j][i];
            }
            if(check(temp)){
                System.out.println(Arrays.toString(temp));
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean check(int[] arr) {

        isLadder = new boolean[N];

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) continue;

            if (Math.abs(arr[i] - arr[i + 1]) >= 2) {
                return false;
            }

            if (Math.abs(arr[i] - arr[i + 1]) == 1) {

                if (arr[i] > arr[i + 1]) {
                    if (i + L < arr.length) {
                        for (int j = i + 1; j <= i + L; j++) {
                            if (arr[j] != arr[i + 1]) {
                                return false;
                            }
                        }
                        for (int j = i + 1; j <= i + L; j++) {
                            if (!isLadder[j]) {
                                isLadder[j] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                    else{
                        return false;
                    }
                }
                else if (arr[i] < arr[i + 1]) {
                    if (i - L >= 0) {
                        for (int j = 0; j < L; j++) {
                            if (arr[i - j] != arr[i]) {
                                return false;
                            }
                        }

                        for (int j = 0; j < L; j++) {
                            if (!isLadder[i - j]) {
                                isLadder[i - j] = true;
                            } else {
                                return false;
                            }
                        }
                    }else{
                        return false;
                    }
                }
            }


        }

        return true;

    }
}
