class Solution {
  public String solution(int n) {
       StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            answer.append(i%2==0?"박":"수");
        }
        return answer.toString();
  }
}
