
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < N; i++) {
      String[] s = br.readLine().toUpperCase().split(" ");
      int index = 0;

      for(int j = 0; j < s[0].length(); j++) {
        if(s[0].charAt(j) == 'X') {
          index = j;
          sb.append(s[1].charAt(index));
          break;
        }
      }
    }

    System.out.println(sb.toString());
  }
}
