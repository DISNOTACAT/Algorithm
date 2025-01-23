import java.util.*;

class Solution {
    public int solution(String my_string) {
        
        int answer = 0;
        
        for(int i = 0; i < my_string.length(); i++) {
            int c = Integer.valueOf(my_string.charAt(i));
            
            if(c >= 48 && c <= 57) {

                answer += (c-48);
            }
        }
        
        return answer;
    }
}