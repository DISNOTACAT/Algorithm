import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        Arrays.sort(array);
        for(int i = (array.length - 1); i > -1; i--){
            if(array[i] <= height) break;
            answer++;
        }
        
        return answer;
    }
}