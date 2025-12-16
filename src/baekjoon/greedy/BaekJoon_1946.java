package baekjoon.greedy;

import java.util.*;

/**
 * 1차면접 기준 오름차순으로 정렬을한다. 오름차순 정렬은 먼저 순위가 1등부터 정렬한다는 소리이다.
 * 정렬을 보면 1등은 무조건 통과 나머지는 2차점수를 비교해봐야한다.
 * 2차 점수는 1등의 2차점수를 최소등수라고 기준을 잡고 탐색한다.
 * 2등의 2차점수가 1등의 2차등수보다 높으면 2등은 패스 그리고 다시 2등의 2차점수를  최소 등수라고 기준을 잡고 탐색한다.
 */
public class BaekJoon_1946 {

    static int T, N;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            int answer = 1;
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                list.add(new int[]{first, second});
            }

            list.sort((a, b) -> {
                return a[0]-b[0];
            });

            //for (int[] ints : list) {
            //    System.out.println(Arrays.toString(ints));
            //}
            int minSecond = list.getFirst()[1];

            for (int i = 1; i <list.size() ; i++) {
                int[] temp = list.get(i);
                int tempSecond = temp[1];
                if(tempSecond<minSecond){
                    answer++;
                    minSecond = tempSecond;
                }
            }
            System.out.println(answer);
        }
    }
}
