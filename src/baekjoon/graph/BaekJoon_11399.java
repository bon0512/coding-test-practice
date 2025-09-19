package baekjoon.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_11399 {

    static int N;
    static int M;
    static boolean clear = false;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];



        for (int i = 0; i < N; i++) {
            dfs(0, i);
            if(clear) break;
        }

        if(clear) System.out.println(1);
        else System.out.println(0);

    }

    static private void dfs(int depth, int start) {
        if(depth == 4){
            clear = true;
            return ;
        }

        if(clear){
            return;
        }
        visited[start] =true;

        for (Integer next : graph[start]) {
            if(!visited[next]) dfs(depth+1,next );
        }

        visited[start] =false;


    }
}
