import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> map = new HashMap<>();
        for(String str : participant){
            
            if(!map.containsKey(str)){
                map.put(str, 1);
            } else {
                map.put(str, (map.get(str) + 1));
            }
        }
        
        for(String str : completion){
            map.put(str,(map.get(str) - 1));
        }
       
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(1)){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}