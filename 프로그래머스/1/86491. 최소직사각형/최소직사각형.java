import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(h > w) {
                int temp = w;
                w = h;
                h = temp;
            }
            
            width = Math.max(width, w);
            height = Math.max(height, h);
        }
        
        
        return width * height;
    }
}