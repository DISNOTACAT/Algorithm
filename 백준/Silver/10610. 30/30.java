import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split("");

    int sum = 0;
    boolean zeroFlag = false;
    for(String s : inputs){

      if(s.equals("0")) zeroFlag = true;
      sum += Integer.parseInt(s);
    }

    if(!zeroFlag || sum%3 != 0){
      System.out.println(-1);
      return;
    }

    Arrays.sort(inputs);
    Collections.reverse(Arrays.asList(inputs));
    for(String s : inputs){
      System.out.print(s);
    }

  }

}
