import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);

    int a = 0;
    int b = n-1;
    int answer = Integer.MAX_VALUE;
    int answerA = a;
    int answerB = b;
    while(a < b) {
      int result = arr[a] + arr[b];

      if(result == 0) {
        System.out.println(arr[a] + " " + arr[b]);
        return;
      }

      if(Math.abs(result) < answer) {
        answerA = a;
        answerB = b;
        answer = Math.abs(result);
      }

      if(result < 0) {
        a++;
      } else {
        b--;
      }
    }

    System.out.println(arr[answerA] + " " + arr[answerB]);
  }

}
