class Solution {
    public int solution(int a, int b) {
        int c = Integer.parseInt(""+ a + b);
        return c > (2*a*b) ? c : (2*a*b);
    }
}