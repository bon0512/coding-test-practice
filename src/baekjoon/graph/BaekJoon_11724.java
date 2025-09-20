package baekjoon.graph;

import java.util.*;

/**
 * 연결요소 개수 찾기 문제 11724 DFS로 쉽게 해결 할 수 있다.
 */
public class BaekJoon_11724 {

    static List<Integer>[] list;
    static int N;
    static int M;
    static boolean[] visited;
    static int count = 0;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }

        /*for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }*/

        for (int i = 1; i < N+1; i++) {
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }

        System.out.print(count);

    }

    // dfs로 문제품
    /*private static void dfs(int start){

        visited[start] =true;
        for(int next : list[start]){
            if(!visited[next]) dfs(next);
        }

    }*/

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }

}
