import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int num = Integer.parseInt(input[0]);
    int index = Integer.parseInt(input[1]) - 1;

    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 1; i <= num; i++) {

      if(num % i == 0) {
        list.add(i);
      }
    }
    
    if(list.size() < index+1) {
      System.out.println(0);
      return;
    }

    System.out.println(list.get(index));
  }

}
