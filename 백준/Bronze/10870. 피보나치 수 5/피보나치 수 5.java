
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    System.out.println(fibonacci(num));
  }

  private static int fibonacci(int num) {
    if (num == 0) {
      return 0;
    }
    if (num == 1) {
      return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
  }

}
