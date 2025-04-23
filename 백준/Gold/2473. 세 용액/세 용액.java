import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    long[] arr = new long[N];
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    long[] answer = solution(arr);
    Arrays.sort(answer);

    for(long l : answer) {
      System.out.print(l + " ");
    }
  }

  private static long[] solution(long[] arr) {

    int fixedIndex = 0;
    long[] answer = new long[3];
    long min = Long.MAX_VALUE;


    while(fixedIndex < arr.length) {

      int leftIndex = 0;
      int rightIndex = arr.length - 1;

      while(arr[leftIndex] < arr[rightIndex]) {

        if(leftIndex == fixedIndex) {
          leftIndex++;
          continue;
        }

        if(rightIndex == fixedIndex) {
          rightIndex--;
          continue;
        }


        long sum = arr[fixedIndex] + arr[leftIndex] + arr[rightIndex];

        if(sum == 0) return new long[]{arr[fixedIndex], arr[leftIndex], arr[rightIndex]};

        if(Math.abs(sum) < min) {
          answer[0] = arr[fixedIndex];
          answer[1] = arr[rightIndex];
          answer[2] = arr[leftIndex];
          min = Math.abs(sum);
        }

        if(sum > 0) {

          if(arr[rightIndex] < 0) {
            leftIndex++;
            continue;
          }

          rightIndex--;
        }

        if(sum < 0) {

          if(arr[leftIndex] > 0) {
            rightIndex--;
            continue;
          }

          leftIndex++;
        }
      }
      fixedIndex++;
    }

    return answer;
  }

}
