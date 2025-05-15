package list;
import java.util.*;

public class ArrayListPractice {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        System.out.println("list = " + list);

        ArrayList<Integer> list2 = new ArrayList<>(list);
        System.out.println("list2 = " + list2);

        System.out.println("list.get(0) = " + list.get(0));
        
        list.remove(list.size()-1);
        System.out.println("list = " + list);

        int[] arr = {1,2,5,3,4};

        System.out.println(arr.length);

        Arrays.sort(arr);       //정렬
        System.out.println(Arrays.toString(arr));   //출력 [1,2,3,4,5]

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Collections.sort(arrayList);
        System.out.println("arrayList = " + arrayList);



        int[] arr2 = {4,2,2,1,3,4};


        Set<Integer> set = new HashSet<>();

        for (int i : arr2) {
            set.add(i);
        }
        System.out.println(set);

        Integer[] arr3 = new Integer[set.size()];

        int index= 0;
        for(Integer i :set){
            arr3[index++]=i;
        }
        Arrays.sort(arr3,Collections.reverseOrder());

        System.out.println(Arrays.toString(arr3));
    }
    
}
