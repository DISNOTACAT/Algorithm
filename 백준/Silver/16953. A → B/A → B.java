import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  /*
    백트랙킹
    뒤에가 1이라면 1빼기
    뒤에가 짝수라면 나누기
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");

    int A = Integer.parseInt(str[0]);
    int B = Integer.parseInt(str[1]);

    int count = 0;
    while(A < B) {

      count++;

      int lastDigitOfB = B % 10;

      if(lastDigitOfB == 1) {
        B = B / 10;
        continue;
      }

      if(lastDigitOfB % 2 == 0) {
        B = B / 2;
        continue;
      }

      count = -1;
      break;
    }

    if((A != B) || (count == -1)) {
      System.out.println(-1);
      return;
    }

    System.out.println(++count);
  }

}
