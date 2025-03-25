import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int price = Integer.parseInt(br.readLine());
    int rest = 1000 - price;

    int[] coinsPrice = new int[6];

    coinsPrice[0] = 500;
    coinsPrice[1] = 100;
    coinsPrice[2] = 50;
    coinsPrice[3] = 10;
    coinsPrice[4] = 5;
    coinsPrice[5] = 1;


    int[] coinsCount = new int[6];
    while(rest > 0) {

      for(int i = 0; i < 6; i++) {
        coinsCount[i] += rest/coinsPrice[i];
        rest = rest % coinsPrice[i];
      }
    }

    int count = 0;
    for(int i : coinsCount) {
      count += i;
    }
    System.out.println(count);
  }

}
