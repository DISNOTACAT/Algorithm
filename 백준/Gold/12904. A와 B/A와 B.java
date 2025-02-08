import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder S = new StringBuilder(br.readLine());
    StringBuilder T = new StringBuilder(br.readLine());

    // T > S 로 진행
    // 뒤가 A 면 빼고, B라면 빼고 뒤집기

    while(T.length() > S.length()) {

      if(T.charAt(T.length() - 1) == 'A') {

        T.deleteCharAt(T.length() - 1);

      } else if(T.charAt(T.length() - 1) == 'B') {

        T.deleteCharAt(T.length() - 1);
        T.reverse();
      }
    }

    if(T.toString().equals(S.toString())) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

}
