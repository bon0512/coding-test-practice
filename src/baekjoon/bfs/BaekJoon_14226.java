package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_14226 {


    static int S;
    static boolean[][] mem;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();

        mem = new boolean[10000][10000];

        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        //현재 화면에있는 이모티콘 수, 클립보드에 있는 이모티콘 수, 총 연산 시간;
        queue.add(new int[]{1, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int screen = poll[0];
            int clip = poll[1];
            int curTime = poll[2];

            if (screen == S) {
                return curTime;
            }


            if (mem[screen][clip]) continue;
            mem[screen][clip] =true;

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드를 저장한다.


            queue.add(new int[]{screen, screen, curTime + 1});


            //2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.

            queue.add(new int[]{screen + clip, clip, curTime + 1});


            //3. 화면에 있는 이모티콘중 하나를 삭제한다.
            if(screen-1<0) {
                queue.add(new int[]{0, clip, curTime + 1});
            }
            else {
                queue.add(new int[]{screen - 1, clip, curTime + 1});
            }

        }
        return -1;
    }
}
