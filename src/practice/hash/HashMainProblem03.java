package practice.hash;

import java.util.*;


public class HashMainProblem03 {



    private static String[] solution(String[] record){

        /*HashMap<String, String> member = new HashMap<>();
        List<Log> logList = new ArrayList<>();

        for (String r : record) {
            String[] tmp = r.split(" ");
            String command = tmp[0];
            String id = tmp[1];

            if (command.equals("Enter")) {
                String name = tmp[2];
                member.put(id, name);
                logList.add(new Log(command, id));
            } else if (command.equals("Leave")) {
                logList.add(new Log(command, id));
            } else if (command.equals("Change")) {
                String name = tmp[2];
                member.put(id, name);
            }
        }

        List<String> result = new ArrayList<>();

        for (Log log : logList) {
            String name = member.get(log.getId());
            if (log.getLog().equals("Enter")) {
                result.add(name + "님이 들어왔습니다.");
            } else if (log.getLog().equals("Leave")) {
                result.add(name + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
         */

        HashMap<String,String> member = new HashMap<>();
        List<String> logList = new ArrayList<>();

        for(String s : record){
            String[] tmp = s.split(" ");
            String command = tmp[0];


            if(command.equals("Enter")){
                member.put(tmp[1],tmp[2]);
                logList.add(tmp[0]+" "+tmp[1]);
            }else if(command.equals("Leave")){
                logList.add(s);
            }else if(command.equals("Change")){
                member.put(tmp[1],tmp[2]);
            }
        }
        List<String> resultArray = new ArrayList<>();

        for(String s : logList){
            String[] tmp = s.split(" ");
            String command = tmp[0];
            String userId = tmp[1];
            if(command.equals("Enter")){
                resultArray.add(member.get(userId)+"님이" + " 들어왔습니다.");
            }else if(command.equals("Leave")){
                resultArray.add(member.get(userId)+"님이" + " 나갔습니다.");
            }

        }


        return resultArray.toArray(new String[0]);
    }

    static class Log{
        private final String log;
        private final String id;

        public Log(String log, String id) {
            this.log = log;
            this.id = id;
        }

        public String getLog() {
            return log;
        }

        public String getId() {
            return id;
        }
    }


}


