import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] students = new int[n];
        Arrays.fill(students, 1); // 모든 학생은 기본적으로 1개의 체육복을 가지고 있음
        
        // 잃어버린 학생 처리
        for (int l : lost) {
            students[l - 1]--;
        }
        
        // 여벌 체육복을 가진 학생 처리
        for (int r : reserve) {
            students[r - 1]++;
        }
        
        // 빌려주기 시뮬레이션
        for (int i = 0; i < n; i++) {
            if (students[i] == 0) { // 체육복이 없는 학생
                if (i > 0 && students[i - 1] == 2) { // 앞 번호 학생이 여벌이 있으면 빌려줌
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n - 1 && students[i + 1] == 2) { // 뒷 번호 학생이 여벌이 있으면 빌려줌
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        // 체육복을 가진 학생 수 카운팅
        int answer = 0;
        for (int s : students) {
            if (s >= 1) answer++;
        }
        
        return answer;
    }
}