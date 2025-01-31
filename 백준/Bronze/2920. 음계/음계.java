import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s  = br.readLine().replace(" ", "");

    switch (s) {
      case "12345678" -> System.out.println("ascending");
      case "87654321" -> System.out.println("descending");
      default -> System.out.println("mixed");
    }

  }

}
