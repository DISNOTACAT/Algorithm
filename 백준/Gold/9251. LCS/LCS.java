import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  /*
    Longest Common Subsequence
    최장 공통 부분 수열
    두 수열이 주어졌을 때 가장 긴 부분 수열.

    A C A Y K P
    C A P C A K
      A   C A K

    C 는 어디서 어디까지 X
    A 가 시작한다 그렇다면 그다음은 어디?
    P 가 시작한다 AP 2개
    C 가 시작한다 AP, AC 2개
    A 가 시작한다 AP, AC, ACA 3개
    ...
    현재 비교하려는 자리 앞에 가장 긴 경우의 수를 찾아야한다
    N 자리의 값은 N-1 의 값과 비교한 MAX 값
    N 까지의 연산을 재사용한다

      A C A Y K P
    C 0 1 1 1 1 1
    A 1 1 2 2 2 2
    P 1 1 2 2 2 3
    C 1 2 ?       ACA 와 CAPC 의 비교이다. (C 가 들어갈 여부를 보기 때문에 실제로는 AC 와 CAP)
    A             네번째 자리의 C 가 들어가기전 가장 큰 값의 상태는 CA 즉 2 이다
    K             C 가 하나 더 들어가면 3이 된다.
                  [I][J] 의 값은 [I-1][J-1] + 1 이거나 + 0  이거나
                  +1 의 경우는 [I]==[J] 일 때 이다
   */

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine();
    String b = br.readLine();

    int[][] dp = new int[a.length()+1][b.length()+1];
    for(int i = 1; i < a.length()+1; i++){
      for(int j = 1; j < b.length()+1; j++){
        if(a.charAt(i-1) == b.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1]+1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    System.out.println(dp[a.length()][b.length()]);

  }
}
