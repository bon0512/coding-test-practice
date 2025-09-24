package baekjoon.graph;

import java.util.*;


public class BaekJoon_1260_Re {

    static int N;
    static int M;
    static int V;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];


        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i < N+1; i++) {
            Collections.sort(graph[i]);
        }
        dfs(V);
        System.out.println();
        bfs(V);


    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start+ " ");
        for (Integer i : graph[start]) {
            if(!visited[i]){
                dfs(i);
            }
        }

    }

    static private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        visited[start] = true;
        queue.add(start);
        System.out.print(start + " ");


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer i : graph[poll]) {
                if (!visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.add(i);
                }
            }
        }

    }
}
