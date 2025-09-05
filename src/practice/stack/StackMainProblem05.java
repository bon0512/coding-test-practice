package practice.stack;

import java.util.*;

public class StackMainProblem05 {


    private static String solution(int n, int k, String[] cmd){

        /*int current = k;
        String[] listName = new String[n]; //원래 명단
        String[] listName2 = new String[n]; //편집되는 명단
        Stack<Integer> garbage = new Stack<>(); //휴지통

        for(int i =0; i<n;i++){ //중복되지 않는 이름 채우기
            listName[i] = "ex"+i;
            listName2[i] = "ex"+i;
        }




        for(int i =0;i<cmd.length;i++){
            if(cmd[i].length()>1){
                String[] parts = cmd[i].split(" ");
                String tmpCommand = parts[0];
                int tmpNumber= Integer.parseInt(parts[1]);

                if(tmpCommand.equals("U")){
                    if(current-tmpNumber>0){
                        current -=tmpNumber;
                    }else{
                        current = 0;
                    }
                }else if(tmpCommand.equals("D")){
                    if(current+tmpNumber>n-1){
                        current=n;
                    }else{
                        current +=tmpNumber;
                    }
                }
            }
            else{
                String tmp = cmd[i];
                if(tmp.equals("C")){
                    //현재 행 삭제
                    listName2[current]="Delete";
                    garbage.push(current);
                    if(current==n-1){
                        current--;
                    }else{
                        current++;
                    }
                }
                else if(tmp.equals("Z")){
                    //복구 하지만 현재 선택한 행은 바뀌지 않는다.
                    if(!garbage.isEmpty()) {
                        int installed = garbage.pop();
                        listName2[installed] = listName[installed];
                    }
                }
            }
        }
        // 결과 문자열 생성
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (listName[i].equals(listName2[i])) {
                answer.append("O");
            } else {
                answer.append("X");
            }
        }

        return answer.toString();

         */ //내가 작성한코드 시간복잡도 초과

        Stack<Integer> deleted = new Stack<>();

        int[]up = new int[n+2];
        int[]down = new int[n+2];
        for (int i = 0; i < n; i++) {
            up[i] = i-1;
            down[i] = i+1;
        }

        k++;

        for (String c : cmd) {

            if(c.startsWith("C")){
                deleted.push(k);
                up[down[k]]=up[k];
                down[up[k]] = down[k];

                k = n< down[k]? up[k]:down[k];
            }
            else if(c.startsWith("Z")){
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }

            else{
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k]:down[k];
                }
            }

        }

        char[] answer = new char[n];
        Arrays.fill(answer,'O');
        for (Integer i : deleted) {
            answer[i-1] = 'X';
        }
        return new String(answer);
    }


}
