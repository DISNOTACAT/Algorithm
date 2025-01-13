import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        Integer[] iarr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            iarr[i] = Integer.parseInt(arr[i]);
        }
    
        Arrays.sort(iarr);
        return iarr[0] + " " + iarr[arr.length - 1];
    }
}