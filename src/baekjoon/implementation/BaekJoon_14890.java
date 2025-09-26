package baekjoon.implementation;

import java.util.*;

public class BaekJoon_14890 {

    static int L;
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


        /**
         * 가로 방향 확인
         */
        for (int i = 0; i < N; i++) {

            if (check(arr[i])) {
                //System.out.println(Arrays.toString(arr[i]));
                count++;
            }
        }

        System.out.println("==세로===g");
        /**
         * 세로 방향 확인
         */
        // System.out.println("==세로===");
        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            for (int j = 0; j < N; j++) {
                temp[j] = arr[j][i];
            }
            if (check(temp)) {
                //System.out.println(Arrays.toString(temp));
                count++;
            }
            /*else{
                System.out.println(Arrays.toString(temp));
                System.out.println(Arrays.toString(isLadder));
            }*/
        }

        System.out.println(count);

    }

    private static boolean check(int[] arr) {

        isLadder = new boolean[N];

        for (int i = 0; i < arr.length - 1; i++) {

            // 높이가 같으면 패스
            if (arr[i] == arr[i + 1]) continue;

            // 높이가 2 이상 차이나면 경사로 설치 불가하므로 false
            if (Math.abs(arr[i] - arr[i + 1]) >= 2) {
                return false;
            }

            // 경사로 설치가 필요한 경우를 봐야하는데 내 앞에 높이가 1보다 작거나 크면 조사
            if (Math.abs(arr[i] - arr[i + 1]) == 1) {

                //내가 앞의경사보다 높은경우
                if (arr[i] > arr[i + 1]) {
                    if (i + L < arr.length) {
                        for (int j = i + 1; j <= i + L; j++) {
                            if (arr[j] != arr[i + 1] || isLadder[j]) {
                                return false;
                            }
                            isLadder[j] = true;
                        }

                    } else {
                        return false;
                    }
                }
                //내가 앞의 경사보다 낮은경우
                //나 포함해서 뒤에 L만큼 경사로를 깔 수 있는지 봐야함
                else if (arr[i] < arr[i + 1]) {
                    if (i + 1 - L >= 0) {
                        for (int j = 0; j < L; j++) {
                            if (arr[i - j] != arr[i]) {
                                return false;
                            }
                        }

                        for (int j = 0; j < L; j++) {
                            if (isLadder[i - j]) {
                                return false;
                            }
                            isLadder[i - j] = true;
                        }
                    } else {
                        return false;
                    }
                }
            }


        }

        return true;

    }
}
