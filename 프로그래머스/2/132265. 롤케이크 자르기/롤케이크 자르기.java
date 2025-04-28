import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        Map<Integer, Integer> right = new HashMap<>();
        for(int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        
        for(int i = 0; i < topping.length; i++) {
            
            int t = topping[i];
            left.add(t);
            
            int mapICount = right.getOrDefault(t, 0);
            if(mapICount > 1) {
                right.put(t, mapICount - 1);
            } else if(mapICount == 1) {
                right.remove(t);
            }
            
            if(right.size() == left.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}