import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<String> que = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            
            String c = String.valueOf(s.charAt(i));
            if(que.isEmpty() || !que.peekLast().equals(c)) {
                que.add(c);
            } else {
                que.removeLast();
            } 
        }

        return que.isEmpty() ? 1 : 0;
    }
}