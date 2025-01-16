import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int sum = d[0];
        
        if(sum > budget) {
            return answer;
        }
        
        for(int i = 1 ; i < d.length; i++) {
            sum += d[i];
            System.out.println(sum);
            
            if(sum > budget) {
                answer = i;
                break;
            }
        }
        
        if(answer == 0) answer = d.length;
        
        return answer;
    }
}