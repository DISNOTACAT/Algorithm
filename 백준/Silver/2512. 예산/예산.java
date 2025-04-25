import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] requests = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < N; i++) {
      requests[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(requests);

    int M = Integer.parseInt(br.readLine());
    int max = requests[N-1];
    int min = 1;
    int mid, sum;

    while(max >= min) {

      mid = (max + min) / 2;
      sum = 0;
      for(int request : requests){
        sum += Math.min(mid, request);
      }

      if(sum > M) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.println(max);
  }

}
