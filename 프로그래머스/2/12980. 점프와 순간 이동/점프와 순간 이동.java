import java.util.*;

public class Solution {
    public int solution(int n) {
        int energy = 0;

        // 1 + 2^ 씩 진행한다.
        // 11이라면?
        // 1 -> (2)- > (4) - > (8) -> 11 = 4
        // 11 -> (10) -> 5 -> (4) -> (2) -> 1 = 3
        
        // 20 ?
        // 20 -> 10 -> 5 -> 4! -> 2 -> 1! = 2
        
        if( n == 1) {
         return 1;   
        }
        
        while(n > 0) {
                    
            if(n%2 != 0) {
                energy++;
                n--;
            } else {
                n = n/2;
            }
        }
        

        return energy;
    }
}