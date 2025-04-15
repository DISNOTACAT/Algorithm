import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String octopus = "1 2 ";
    int routine = n/2;

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= routine; i++) {
      sb.append(octopus);
    }

    if(n%2 > 0) {
      sb.append("3");
    }

    System.out.println(sb);
  }

}
