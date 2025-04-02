import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] words = br.readLine().split(" ");

    for (int i = 1; i < N; i++) {

      if(words[i].charAt(0) != words[i-1].charAt(0)) {
        System.out.println(0);
        return;
      }
    }

    System.out.println(1);
  }
}
