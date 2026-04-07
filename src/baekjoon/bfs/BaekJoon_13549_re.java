package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_13549_re {
    static int N,K;
    static int[] time;
    static int[] dx = {1,-1,2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        time = new int[100001];

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.MAX_VALUE;
        }

        bfs();
    }

    private static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        time[N] = 0;
        queue.add(new int[]{N,0});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int curTime = poll[1];

            if(cur == K){
                System.out.println(curTime);
                return;
            }

            if(cur*2>=0 && cur*2<=100000){
                if(time[cur*2]>curTime){
                    time[cur*2] = curTime;
                    queue.addFirst(new int[]{cur*2,curTime});
                }
            }

            if(cur+1>=0 && cur+1<=100000){
                if(time[cur+1]>curTime){
                    time[cur+1] = curTime+1;
                    queue.addLast(new int[]{cur+1,curTime+1});
                }
            }

            if(cur-1>=0 && cur-1<=100000){
                if(time[cur-1]>curTime){
                    time[cur-1] = curTime+1;
                    queue.addLast(new int[]{cur-1,curTime+1});
                }
            }



        }
    }
}
