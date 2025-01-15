
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {

    solution();
  }

  public static void solution() throws IOException {

    /*
    + 끼리 최대한 묶기
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String answer = "(" + str.replaceAll("-", ")-(") + ")";

    String[] arr = br.readLine().split("-");
    int[] n = new int[arr.length];

    for(int i = 0; i < arr.length; i++){
      String[] plus = arr[i].split("\\+");
      for(int j = 0; j < plus.length; j++){
        n[i] += Integer.parseInt(plus[j]);
      }
    }
    int answer = n[0];
    for(int i = 1; i < n.length; i++){
      answer -= n[i];
    }
    System.out.println(answer);
  }
}
