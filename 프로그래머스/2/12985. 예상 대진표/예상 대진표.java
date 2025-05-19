import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        //math.round >> 현재 번호에서 2로 나눠 올림한 값이 다음 라운드 번호
        // 둘이 같아질떄의 반환

        while(a != b) {
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }

        return answer;
    }
}