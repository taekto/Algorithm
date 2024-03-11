import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int genrePlays;
        int plays;
        int num;
        String genre;
        public Node(int genrePlays, int plays, int num, String genre) {
            this.genrePlays = genrePlays;
            this.plays = plays;
            this.num = num;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.genrePlays == o.genrePlays) {
                if(this.plays == o.plays) {
                    return this.num - o.num;
                }
                else return o.plays - this.plays;
            }
            else return o.genrePlays - this.genrePlays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Node> list = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<genres.length;i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
        }
        

        for(int i=0;i<genres.length;i++) {
            list.add(new Node(hm.get(genres[i]), plays[i], i, genres[i]));
        }
        
        Collections.sort(list);
        HashMap<String, Integer> check = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<genres.length;i++) {
            if(check.getOrDefault(list.get(i).genre, 0) < 2) {
                check.put(list.get(i).genre, check.getOrDefault(list.get(i).genre, 0)+1);
                result.add(list.get(i).num);
            }
        }
        
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            ans[i] = result.get(i);
        }
        
        
        return ans;
    }
}