import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static int max = Integer.MIN_VALUE;
  private static int N;
  private static int[] arr;
  private static boolean[] visited;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    for(int i = 0; i < N; i++) {
      visited = new boolean[N];
      visited[i] = true;
      solution(0, i, 1);
    }
    System.out.println(max);
  }

  private static void solution(int result, int frontIndex, int depth){

    if(depth == N) {
      max = Math.max(max, result);
      return;
    }

    for(int i = 0;  i < N; i++) {

      if(visited[i]) continue;
      visited[i] = true;

      int temp = result + Math.abs(arr[frontIndex] - arr[i]);
      solution(temp, i, depth + 1);

      visited[i] = false; // 백트래킹
    }
  }
}
