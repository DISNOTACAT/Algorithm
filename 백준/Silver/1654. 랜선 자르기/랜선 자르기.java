import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int K = Integer.parseInt(input[0]);
    int N = Integer.parseInt(input[1]);

    if(N == 1) {
      System.out.println(br.readLine());
      return;
    }

    int[] lines = new int[K];
    int maxLen = 0;
    for(int i = 0; i < K; i++) {
      lines[i] = Integer.parseInt(br.readLine());
      maxLen = Math.max(maxLen, lines[i]);
    }

    long max = maxLen;
    long min = 1;
    long mid = 0;

    while(max >= min) {

      mid = (max + min) / 2;

      long sum = 0;
      for(int i : lines) {
        sum += i/mid;
      }

      if(sum < N) max = mid - 1;
      else min = mid + 1;
    }

    System.out.println(max);
  }



}
