import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] trees = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    int low = 0;
    int high = 0;
    for(int i = 0 ; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
      high = Math.max(high, trees[i]);
    }

    int result = 0;
    while(low <= high) {
      int mid = (low + high) / 2;
      long sum = 0;

      for(int i : trees){
        if(i > mid) {
          sum += (i - mid);
        }
      }

      if(sum >= M) {
        result = mid;      // 더 많이 얻었으므로 자를 높이 올려도 됨
        low = mid + 1;
      } else {
        high = mid - 1;    // 너무 적게 얻었으므로 자를 높이 낮춤
      }
    }

    System.out.println(result);
  }
}
