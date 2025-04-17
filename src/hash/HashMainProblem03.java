package hash;

import java.util.*;


public class HashMainProblem03 {



    private static String[] solution(String[] record){

        HashMap<String,String> member = new HashMap<>();
        Log[] log = new Log[record.length];


        for(int i = 0; i<record.length;i++){
            String[] tmp = record[i].split(" ");
            if(tmp[1].equals("Leave")){
                log[i] = new Log(tmp[1],tmp[2]);
            }
            else if(tmp[1].equals("Enter")){
                log[i] = new Log(tmp[1],tmp[2]);
                member.put(tmp[2],tmp[3]);
            }
            else if(tmp[1].equals("Change")){
                log[i] = new Log(tmp[1],tmp[2]);
                if(member.containsKey(tmp[2])){
                    member.put(tmp[2],tmp[3]);
                }
            }
        }
        ArrayList<String> resultArray = new ArrayList<>();

        for (Log logTmp : log) {
            if(logTmp.getLog().equals("Enter")){
                String name = member.get(logTmp.getId());
                resultArray.add(name+"님이 들어왔습니다.");
            }
            else if(logTmp.getLog().equals("Leave")){
                String name = member.get(logTmp.getId());
                resultArray.add(name+"님이 나갔습니다.");
            }

        }

        return resultArray.toArray(new String[0]);
    }

    static class Log{
        String id;
        String log;

        public Log(String log, String id){
            this.id =id;
            this.log = log;
        }
        public String getLog(){
            return log;
        }

        public void setLog(String log){
            this.log = log;
        }

        public String getId(){
            return id;
        }


    }


}


