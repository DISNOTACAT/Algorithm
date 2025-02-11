
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {

      String s = br.readLine();
      count  = 0;

      System.out.println(isPalindrome(s) + " " + count);
    }
    br.close();
  }

  private static int recursion(String s, int l, int r) {
    count++;
    if (l >= r) return 1;
    else if(s.charAt(l) != s.charAt(r)) return 0;
    return recursion(s, l+1, r-1);
  }

  private static int isPalindrome (String s) {
    return recursion(s, 0, s.length()-1);
  }

}
