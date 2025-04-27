import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split("");

    int[] foods = new int[input.length];
    int chicken = 0;
    int etc = 0;
    for(int i = 0; i < input.length; i++){

      if(input[i].equals("C")) {
        foods[i] = 1;
        chicken++;
      } else {
        etc++;
      }
    }
    
    System.out.println(chicken % (etc+1) > 0 ? chicken/(etc+1)+1 : chicken/(etc+1));

  }

}
