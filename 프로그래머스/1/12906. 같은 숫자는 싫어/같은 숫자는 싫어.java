import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> que = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            
            if(que.isEmpty() || que.peekLast() != arr[i]) {
                que.add(arr[i]);
            } 
        }
        
        int[] answer = new int[que.size()];
        
        for(int i = 0; i < answer.length; i++){
            
            answer[i] = que.remove();
        }

        return answer;
    }
}