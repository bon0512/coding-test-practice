package baekjoon.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.IntFunction;

public class BaekJoon_1753 {


    static int V, E, start;
    static ArrayList<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new int[]{v, w});
        }

        bfs(start);


    }

    private static void bfs(int start) {

        //현재 노드와 시작점에서 현재노드까지의 최소거리를 넣어준다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //시작점부터 각 노드까지의 최단거리 배열
        // 초기화해준다
        Arrays.fill(dist,Integer.MAX_VALUE);

        //시작점부터 시작점은 거리가 없으니 당연히 0
        dist[start] = 0;

        //우선순위 큐에 추가 (시작 노드와 , 시작노드의 거리)
        pq.add(new int[]{start,dist[start]});

        //우선순위 큐를 돌면서 거리가 최소인
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int cur = poll[0];
            int curDist = poll[1];

            //현재거리가 최단거리보다 크면 그냥 넘긴다.
            if(curDist> dist[cur]) continue;

            for(int[] edge : graph[cur]){
                int next = edge[0];
                int nextDist = edge[1];


                //만약 최단거리배열에 적힌 넥스트 노드 최단거리가  현재 최단거리 + 가중치 값보다 크다면 갱신해주고 큐에 넣어줘야한다.
                if(dist[next] > dist[cur]+nextDist){
                    dist[next] = dist[cur]+nextDist;
                    pq.add(new int[]{next,dist[cur]+nextDist});
                }
            }

        }

        for (int i = 1; i <dist.length ; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }

            System.out.println(dist[i]);

        }


    }
}
