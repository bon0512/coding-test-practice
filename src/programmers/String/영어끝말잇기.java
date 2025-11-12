package programmers.String;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        int[] arr = new int[n+1];

        boolean dropOut = false;

        int number=1;
        char lastWords = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        arr[1]++;

        for(int i = 1; i <words.length;i++){

            number = (i%n)+1;
            arr[number]++;


            if(lastWords != words[i].charAt(0)){
                dropOut = true;
                break;
            }

            if(set.contains(words[i])){
                dropOut = true;
                break;
            }
            set.add(words[i]);
            lastWords = words[i].charAt(words[i].length()-1);



        }

        if(dropOut) return new int[]{number,arr[number]};
        else return new int[]{0,0};
    }
}
