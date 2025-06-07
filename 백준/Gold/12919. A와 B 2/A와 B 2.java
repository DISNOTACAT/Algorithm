import java.io.*;

public class Main {

  private static String S;
  private static String T;

  private static int result = 0;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = br.readLine();
    T = br.readLine();

    dfs(T);
    System.out.println(result);

  }

  private static void dfs(String T){

    // 답이면 복귀
    if(T.equals(S)) {
      result = 1;
      return;
    }

    // 답이 될 수 없는 상태면 복귀
    if(T.length() <= S.length()) {
      return;
    }

    // A 자를 수 있다면 자르기
    if(T.charAt(T.length()-1) == 'A') {
      dfs(T.substring(0, T.length() - 1));
    }

    // B 자를 수 있다면 자르기
    if(T.charAt(0) == 'B') {
      StringBuilder sb = new StringBuilder(T.substring(1));
      dfs(sb.reverse().toString());
    }
    // 재귀
  }
}
