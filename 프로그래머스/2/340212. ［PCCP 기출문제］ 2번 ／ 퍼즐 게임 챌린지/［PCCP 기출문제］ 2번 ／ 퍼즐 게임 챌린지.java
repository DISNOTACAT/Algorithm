import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
    
    // diff <= level ? time = time_cur;
    // diff > level ? time = ((diff - level) * (time_cur + time_prev) + time_cur;
        
        // diffs 양 끝에서 중간 점 찾기
        
        int[] levels = diffs.clone();
        Arrays.sort(levels);
        
        int start = levels[0];
        int end = levels[levels.length-1];
        int answer = 0;
        
        while(start <= end) {
            
            answer = (start + end)/2;
            long totalTime = 0;

            for(int i = 0; i < diffs.length; i++) {

                if(diffs[i] <= answer) {
                    totalTime += times[i];
                } else {
                    totalTime += (times[i] + times[i-1 == 0 ? 0 : i-1]) * (diffs[i] - answer) + times[i];
                }
            }
            
            if(totalTime > limit) {
                start = answer + 1;
            } else {
                end = answer - 1;
            } ;
        }
    
        return start;
    }
}