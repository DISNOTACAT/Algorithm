import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<String> stack = new ArrayDeque<>();
        String[] str = s.split("");
        boolean answer = true;
        
        for(int i = 0; i < s.length(); i++) {
            
            if(str[i].equals("(")) {
                stack.push(str[i]);
                continue;
            }
            
            if(stack.isEmpty() && str[i].equals(")")) {
                return false;
            }
            
            stack.pop();
        }

        return stack.isEmpty();
    }
}