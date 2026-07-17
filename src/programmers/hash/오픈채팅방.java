package programmers.hash;

import java.util.*;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();

        // 1. 아이디별 최종 닉네임 저장
        for (String log : record) {
            String[] parts = log.split(" ");
            String command = parts[0];
            String id = parts[1];

            if (command.equals("Enter") || command.equals("Change")) {
                nicknameMap.put(id, parts[2]);
            }
        }

        // 2. Enter와 Leave 기록만 결과로 변환
        List<String> answer = new ArrayList<>();

        for (String log : record) {
            String[] parts = log.split(" ");
            String command = parts[0];
            String id = parts[1];
            String nickname = nicknameMap.get(id);

            if (command.equals("Enter")) {
                answer.add(nickname + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answer.add(nickname + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
