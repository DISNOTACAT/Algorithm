class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean answer = false;
        
        answer = eq.equals("=") ? (ineq.equals(">") ? n>=m  : n<=m) : (ineq.equals(">") ? n>m  : n<m);
        
        
        return answer ? 1 : 0;
    }
}