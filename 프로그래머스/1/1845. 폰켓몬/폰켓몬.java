import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 절반의 수가 포켓몬 종류보다 많다면 return 종류수, 반대라면 return 절반 수
        int half = nums.length/2;
        HashSet<Integer> hset = new HashSet<>();
        
        for(int i : nums){
            hset.add(i);
        }
        
        if(hset.size() < half){
            answer = hset.size();
        } else {
            answer = half;
        }
        
        return answer;
    }
}