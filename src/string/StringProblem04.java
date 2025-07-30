package string;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 알고리즘문제 그룹단어 체커
 *
 */
public class StringProblem04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행제거

        boolean word;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            word =true;
            String s = sc.nextLine();

            Set<Character> existWord = new HashSet<>();
            char prev = s.charAt(0);
            existWord.add(prev);

            for(int j =1; j<s.length();j++){
                char c = s.charAt(j);

                if(prev!=c){

                    if(existWord.contains(c)){
                        word =false;
                        break;
                    }
                    existWord.add(c);
                }

                prev = c;

            }
            if(word) answer++;
        }
        System.out.println(answer);

    }
}
