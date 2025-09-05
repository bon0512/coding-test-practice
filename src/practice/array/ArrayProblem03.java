package practice.array;

public class ArrayProblem03 {

    private static final int dx[] = {0,-1,1,0};
    private static final int dy[] = {-1,0,0,1};
    public int[] solution(String[][] places){
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {

            String[] place = places[i];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            //거리두기 검사

            if(isDistance(room)) result[i]=1;
            else result[i] = 0;


        }
        return result;
    }

    private boolean isDistance(char[][] room){

        for (int col = 0; col < room.length; col++) {
            for (int row = 0; row < room[col].length; row++) {
                if(room[col][row]!='P') continue;

                // 거리두기 검사
                if(!isDistance(room,row,col)) return false;
            }
        }
        return true;
    }

    private boolean isDistance(char[][] room, int row,int col){

        for (int d = 0; d<4;d++){
            int nx = row + dx[d];
            int ny = col + dy[d];
            if(ny<0 || ny>=room.length || nx<0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]){
                case 'P' : return false;
                case 'O' :
                    if(isNextToVolunteer(room,nx,ny,3-d)) return false;
                    break;
            }

        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for (int d = 0;d<4;d++){
            if(d==exclude) continue;
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(ny<0||ny>=room.length||nx<0||nx>=room[ny].length) continue;
            if(room[ny][nx] == 'P') return true;
        }

        return false;
    }

}
