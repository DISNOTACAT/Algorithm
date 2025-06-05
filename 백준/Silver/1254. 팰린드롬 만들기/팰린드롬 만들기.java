import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split("");


    int i = 0;
    while(i < str.length) {
      int temp = i;
      for(int j = str.length-1; j >= i; j--) {

        if(j <= temp) {
          System.out.println(str.length + i);
          return;
        }

        if(!str[temp].equals(str[j])) break;

        temp++;
      }
      i++;
    }

    System.out.println(str.length + i);
  }

}
