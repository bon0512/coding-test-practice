package baekjoon.dfs;

import java.util.*;

public class BaekJoon_14225 {


    static int N;
    static Set<Integer> sumSet = new HashSet<>();

    static int[] list;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();

        list = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        System.out.println("시작");

        dfs(0,0);




        //sumList.removeFirst();


        System.out.println(sumSet);

        List<Integer> list = new ArrayList<>(sumSet);
        Collections.sort(list);

        boolean isOrder = false;
        int minIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=i){
                isOrder=true;
                System.out.println(i);
                break;
            }
            minIndex++;
        }

        if(!isOrder){
            System.out.println(minIndex);
        };

        //System.out.println(sumList);
    }

    private static void dfs(int idx, int sum) {
        if (idx == N) {
            sumSet.add(sum);
            return;
        }
        dfs(idx + 1, sum + list[idx]); // idx 선택
        dfs(idx + 1, sum);             // idx 선택 안 함
    }

}
