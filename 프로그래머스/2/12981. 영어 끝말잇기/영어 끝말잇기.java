import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        
        for(int i = 1; i < words.length; i++) {
            
            int temp = map.getOrDefault(words[i], 0);
            
            if(temp == 1 || !check(words[i], words[i-1])) {
                answer[0] = i % n + 1;
                int sq = (i + 1) % n;
                if(sq == 0){
                    answer[1] = (i + 1) / n;
                } else {
                    answer[1] = ((i + 1) / n) + 1;
                }
                
                break;
            }
            map.put(words[i], 1);            
            
        }
        
        if(answer[1] == 0) {
            answer[0] = 0;
        }
        

        return answer;
    }
    
    public static boolean check(String cur, String pre) {
        System.out.println("cur == " + cur);
        return cur.charAt(0) == pre.charAt(pre.length() - 1);
    }
}