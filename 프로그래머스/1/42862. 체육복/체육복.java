import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 최소 수업 가능한 학생수 = 전체 - 도난당한 학생 수
        int student = n - lost.length;
        
        // 도난당했지만 여벌 체육복이 있는 학생을 제외
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                
                if(lost[i] == reserve[j]){  // 있다면 해당 학생 번호는 예외처리
                    lost[i] = -1;
                    reserve[j] = -1;
                    student++;
                }
            }
        }
        
        // 여벌옷이 없는 학생 확인
         for(int i = 0; i < lost.length; i++){
             
            if(lost[i] == -1) continue;
             
            for(int j = 0; j < reserve.length; j++){
            
                if(reserve[j] == -1) continue;
                
                if(lost[i] - reserve[j] == 1 || lost[i] - reserve[j] == -1){
                    lost[i] = -1;
                    reserve[j] = -1;
                    student++;
                }
                    
            }
         }
                
        return student;
    }
}