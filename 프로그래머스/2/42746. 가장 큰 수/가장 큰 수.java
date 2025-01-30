import java.util.*;

class Solution {
    public String solution(int[] array) {
        
        String[] str = new String[array.length];
        
        for(int i = 0; i < array.length; i++){
            str[i] = String.valueOf(array[i]);
        }
        
        Arrays.sort(str, (s2, s1) -> (s1+s2).compareTo(s2+s1));
        
        StringBuilder answer = new StringBuilder();
        
        for(String s : str) {
            answer.append(s);
        }
        
        if(str[0].equals("0")) {
            return "0";
        }
        
        
        return answer.toString();
    }
}