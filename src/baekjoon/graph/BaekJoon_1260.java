package baekjoon.graph;

import java.util.*;

public class BaekJoon_1260 {

    static int N;
    static int M;
    static int start;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean[] visited_bfs;
    StringBuilder dfs_sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visited_bfs = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        dfs(start);
        System.out.println();
        bfs(start);

    }


    private static void dfs(int index) {
        visited[index] = true;
        System.out.print(index + " ");
        for (Integer next : list[index]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int index) {
        Queue<List<Integer>> queue = new LinkedList<>();

        visited_bfs[index] = true;
        queue.add(list[index]);
        System.out.print(index + " ");

        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            for (int i : temp) {
                if (!visited_bfs[i]) {
                    visited_bfs[i] = true;
                    System.out.print(i + " ");
                    queue.add(list[i]);
                }
            }
        }


    }
}
