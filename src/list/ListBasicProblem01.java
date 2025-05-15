package list;
import java.util.*;

public class ListBasicProblem01 {
    public static void main(String[] args) {

        int[] arr = {2,1,3,4,1};
        int[] arr2 = {5,0,2,7};

        Set<Integer> set1 = new HashSet<>();

        for(int i = 0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                set1.add(arr[i]+arr[j]);
            }
        }

        int[] result = new int[set1.size()];
        int index = 0;
        for(Integer i : set1){
            result[index++]=i;
        }
        
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

}
