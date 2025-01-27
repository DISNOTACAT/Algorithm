import java.util.*;

class Solution {
    public String solution(String s, int n) {

        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == ' '){
                answer += " ";
                continue;
            }
            
            int cur = Integer.valueOf(s.charAt(i));
            int move = cur + n;
                
            if(cur <= 90 && move > 90) {
                move = (move - 90) + 64;
            } else if(move > 122) {
                move = (move - 122) + 96;
            }                
            
            answer += (char) move;
        }
        
        return answer;
    }
}