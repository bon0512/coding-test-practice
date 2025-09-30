package baekjoon.graph;

import java.util.*;

public class BaekJoon_2606 {

    static int N;
    static int M;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N+1];

        visited = new boolean[N+1];

        for (int i = 0; i <list.length ; i++) {
            list[i] = new ArrayList<>();

        }


        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }

        //bfs(1);
        dfs(1);
        int answer =0;
        for (int i = 1; i <=N ; i++) {
            if(visited[i]) answer++;
        }

        //System.out.println(Arrays.toString(visited));

        System.out.println(answer-1);


    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]= true;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();

            for (Integer next : list[poll]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }

    private static void dfs(int start){
        visited[start]=true;
        for (Integer next : list[start]) {
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
