package baekjoon.dijkstra;

import java.util.*;



public class BaekJoon_17835 {

    static int N, M, K;
    static ArrayList<int[]>[] graph;
    static long[] dist;
    static List<Integer> test;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int j = 0; j < M; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();


            graph[v].add(new int[]{u, c});
        }

        test = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int temp = sc.nextInt();
            test.add(temp);
        }

        bfs();
    }

    private static void bfs() {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for (Integer i : test) {
            dist[i] = 0;
            pq.add(new long[]{i, 0});
        }

        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            int cur = (int) poll[0];
            long curDist = poll[1];

            if (curDist > dist[cur]) continue;

            for (int[] node : graph[cur]) {
                int next = node[0];
                long nextDist = node[1];

                if (dist[next] > dist[cur] + nextDist) {
                    dist[next] = dist[cur] + nextDist;
                    pq.add(new long[]{next, dist[next]});
                }
            }
        }

        long maxValue = Long.MIN_VALUE;
        int city = -1;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] != Long.MAX_VALUE && dist[i] > maxValue) {
                maxValue = dist[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(maxValue);
    }
}