import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    int candySum = Arrays.stream(Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray()).sum();

    System.out.println(candySum >= T ? "Padaeng_i Happy" : "Padaeng_i Cry");


  }

}
