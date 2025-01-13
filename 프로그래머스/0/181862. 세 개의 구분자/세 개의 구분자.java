import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        String my = myStr.replace("a", " ").replace("b", " ").replace("c", " ");
        
        String[] tmp = my.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for(String str : tmp) {
            str = str.trim();
            if(str.length() > 0) {
                arr.add(str);
            }
        }
        
        if(arr.size() == 0) {
            String[] empty = {"EMPTY"};
            return empty;
        }
        String[] answer = new String[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
            
        
        return answer;
    }
}