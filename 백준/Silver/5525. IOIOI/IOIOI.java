
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Pn = Integer.parseInt(br.readLine());
    int length = Integer.parseInt(br.readLine());
    String str = br.readLine();

    int answer = 0;
    int startIdx = 0;

    while(startIdx + (Pn * 2) < length) {

      if(str.charAt(startIdx) == 'I') {

        int tempPn = 0;
        int tempIdx = startIdx;
        while(tempPn < Pn) {

          if(str.charAt(tempIdx + 1) == 'O' && str.charAt(tempIdx + 2) == 'I') {
            tempPn++;
            tempIdx = tempIdx + 2;
          } else {
            break;
          }
        }

        if(tempPn == Pn) {
          answer ++;
          startIdx++;
        }
      }

      startIdx++;
    }

    System.out.println(answer);
  }
}
