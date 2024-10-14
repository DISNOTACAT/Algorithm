import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        int idx;
        
        for(idx=0; idx <completion.length; idx++){
            if(!participant[idx].equals(completion[idx])){
                return  participant[idx];
            }
        }
        
        return participant[idx];
    }
}