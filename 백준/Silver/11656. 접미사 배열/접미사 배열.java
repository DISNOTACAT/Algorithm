
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder s = new StringBuilder(br.readLine());


    String[] arr = new String[s.length()];
    for (int i = 0; i < s.length(); i++) {
      arr[i] = s.substring(i);
    }

    Arrays.sort(arr);

    for(String str : arr) {
      System.out.println(str);
    }
  }
}
