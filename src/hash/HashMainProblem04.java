package hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMainProblem04 {



    private static int[] solution(String[] genres, int[] plays){


        HashMap<String,Integer> listenCountGenres = new HashMap<>();
        HashMap<String, ArrayList<int[]>>genresSongList = new HashMap<>();

        for(int i = 0 ;i<genres.length;i++) {
            listenCountGenres.put(genres[i], listenCountGenres.getOrDefault(genres[i], 0) + plays[i]);

            if(!genresSongList.containsKey(genres[i])){
                genresSongList.put(genres[i],new ArrayList<>());
            }
            genresSongList.get(genres[i]).add(new int[]{plays[i],i});
        }

        ArrayList<String> genreOrder = new ArrayList<>(listenCountGenres.keySet());

        genreOrder.sort((s1,s2)-> listenCountGenres.get(s2)-listenCountGenres.get(s1));



        return null;
    }

}
