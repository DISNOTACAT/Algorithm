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
    int tempPn = 0;

    for(int i = 0; i < length - 2; i++) {
      
      if(str.charAt(i) == 'I' && (str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I')) {
        tempPn++;
        
        if(tempPn == Pn) {
          answer++;
          tempPn--;
        }
        i++;
      
      } else {
        
        tempPn = 0;
      }
    }
    

    System.out.println(answer);
  }
}
