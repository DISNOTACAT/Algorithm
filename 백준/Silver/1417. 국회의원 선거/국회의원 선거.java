import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  /*
    배열에 각 후보의 득표 수를 넣는다.
    다솜이 혼자 거나, 다솜이가 가장 큰 수라면 0을 출력한다.
    가장 큰 표를 받을 사람을 -1 다솜이를 +1 한다. 다솜이가 가장 커질 떄까지 반복
   */

  static int cost = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    if(n == 1) {
      System.out.println(0);
      return;
    }

    int[] arr = new int[n-1];
    int dasom = Integer.parseInt(br.readLine());

    for(int i = 0; i < n-1; i ++) {
      int num = Integer.parseInt(br.readLine());
      arr[i] = num;
    }

    changeMaxToDasom(dasom, arr);
    System.out.println(cost);
  }

  private static void changeMaxToDasom(int dasom, int[] arr) {

    Arrays.sort(arr);

    if(arr[arr.length-1] >= dasom) {
      arr[arr.length-1]--;
      dasom++;
      cost++;

      changeMaxToDasom(dasom, arr);

    }


  }

}
