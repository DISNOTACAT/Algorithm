import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String code) {
        
        int mode = 0;
        StringBuilder sb = new StringBuilder();
                                                      
        for(int i = 0; i < code.length(); i++){
            char ch = code.charAt(i);                

            
            if(ch == '1'){
                mode = 1 - mode;
            } else if((mode == 0 && i%2 == 0) || (mode == 1 && i%2 > 0)) {
                sb.append(ch);
            }
            
        }
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}