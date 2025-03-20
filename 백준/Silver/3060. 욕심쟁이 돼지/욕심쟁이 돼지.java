import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    while(N --> 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long delivered = Integer.parseInt(st.nextToken());

      long feed = 0;
      st = new StringTokenizer(br.readLine(), " ");
      for(int i = 0; i < 6; i++) {
        feed += Integer.parseInt(st.nextToken());
      }

      int day = 1;
      while(delivered >= feed) {
        feed *= 4;
        ++day;
      }
      System.out.println(day);
    }
  }

}
