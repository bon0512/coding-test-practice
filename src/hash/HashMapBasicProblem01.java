package hash;
import java.util.*;

public class HashMapBasicProblem01 {

    /**
     * n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주여졌을때 이 중에서 합이 target인
      두 수가 arr에 있는지 찾고, 있으면 true 없으면 false를 반환하는 solution 함수 작성
     *
     * arr 원소 a , b target을  k라고한다면 a+b = k 가 되어야한다.
     * 다 더하면 O(n^2)이 되지만 원소의 유무값을 저장할 수 있는 해쉬 값을 사용하면 O(n+k)
     */

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,8}, 6 ));
        System.out.println(solution(new int[]{2,3,5,9}, 10 ));
    }

    private static boolean solution(int[] arr, int target){
        Set<Integer> set = new HashSet<>();

        for(int i : arr){
            if(set.contains(target-i)){
                return true;
            }

            set.add(i);
        }


        return false;
    }
}
