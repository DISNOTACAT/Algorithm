import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");
    int coke = Integer.parseInt(input[0]);
    int beer = Integer.parseInt(input[1]);

    // 치킨 1개 -> -2콜라 or -1맥주
    int count = 0;
    while(N-- > 0) {

      if(coke >= 2) {
        coke -= 2;
        count++;
        continue;
      }

      if(beer >= 1){
         beer--;
         count++;
         continue;
      }

      break;
    }

    System.out.println(count);
  }

}
