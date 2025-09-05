package baekjoon.greedy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 1931번 회의실 배정
 */
public class BaekJoon_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] meetingSchedules = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetingSchedules[i][0] = sc.nextInt();
            meetingSchedules[i][1] = sc.nextInt();
        }

        Arrays.sort(meetingSchedules, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int end = meetingSchedules[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (meetingSchedules[i][0] < end) continue;
            end = meetingSchedules[i][1];
            count++;
        }

        System.out.println(count);
    }
}
