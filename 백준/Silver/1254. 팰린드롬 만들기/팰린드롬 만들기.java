import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int len = str.length();

    for (int i = 0; i < len; i++) {
      String sub = str.substring(i);
      if (isPalindrome(sub)) {
        System.out.println(len + i);
        return;
      }
    }
  }

  private static boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
  }
}
