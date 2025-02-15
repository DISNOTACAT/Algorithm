import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for(int i =0; i < N; i++){

      int n = Integer.parseInt(br.readLine());

      int price = 0;
      String name = "";
      for(int j = 0; j < n; j++){
        String[] str = br.readLine().split(" ");
        if(price < Integer.valueOf(str[0])) {
          price = Integer.valueOf(str[0]);
          name = str[1];
        }
      }
      System.out.println(name);
    }
  }
}
