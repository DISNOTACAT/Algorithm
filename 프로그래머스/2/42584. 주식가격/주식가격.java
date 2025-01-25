import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++){
            
            int cur = prices[i];
            
            for(int j = (i+1); j < prices.length; j++){
                
                if(prices[j] < cur) {
                    answer[i] = j - i;
                    break;
                }
            }
            
            if(answer[i] == 0) {

                answer[i] = prices.length - i - 1;
            }
        }
        
        answer[prices.length - 1] = 0;
        
        
        return answer;
    }
}