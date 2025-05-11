import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int result;
  private static int num;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    while(N --> 0) {
      num = Integer.parseInt(br.readLine());
      result = 0;
      solution(0);
      System.out.println(result);
    }
  }

  private static void solution(int start) {

    if(start == num) {
      result++;
      return;
    }

    if(start > num) {
      return;
    }

      solution(start+1);
      solution(start+2);
      solution(start+3);
  }
}
