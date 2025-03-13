import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    while(n --> 0) {
      StringBuilder sb = new StringBuilder();
      long curNum = Long.parseLong(br.readLine());
      int count = 0;

      if((curNum & (curNum) - 1) == 0) {
        int bit = Long.numberOfTrailingZeros(curNum);
        sb.append(bit-1).append(" ").append(bit - 1);
        System.out.println(sb);
        continue;
      }

      for(int j = 0; j <= 60; j++){

        if((curNum & (1L << j)) > 0) {
          sb.append(j).append(" ");
          count++;
        }

        if(count == 2){
          break;
        }
      }

      System.out.println(sb.toString().trim());
    }
  }

}
