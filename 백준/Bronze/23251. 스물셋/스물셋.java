import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

  private static final int TWENTY_THREE = 23;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    while(N --> 0) {

      System.out.println(TWENTY_THREE * Integer.parseInt(br.readLine()));
    }
  }

}
