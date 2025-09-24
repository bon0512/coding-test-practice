package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  1697 숨바꼭질... bfs 너비 우선 탐색
 */
public class BaekJoon_1697 {

    static boolean[] visited;
    static int N,K;
    static int answer = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new boolean[100_001];

        bfs(N);

        System.out.println(answer);
    }

    private static void bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        visited[n] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int time = poll[1];

            if(cur == K){
                answer = time;
                break;
            }

            for (int i = 0; i < 3; i++) {
                if(i==0){
                    if(cur-1>=0 && cur-1<=100_000 && !visited[cur-1]){
                        visited[cur-1] =true;
                        queue.add(new int[]{cur-1,time+1});
                    }
                }else if(i==1){
                    if(cur+1>=0 && cur+1<=100_000 && !visited[cur+1]){
                        visited[cur+1] =true;
                        queue.add(new int[]{cur+1,time+1});
                    }
                }else{
                    if(cur * 2 >=0 && cur *2<=100_000 && !visited[cur*2]){
                        visited[cur*2] =true;
                        queue.add(new int[]{cur*2,time+1});
                    }
                }
            }
        }


    }
}
