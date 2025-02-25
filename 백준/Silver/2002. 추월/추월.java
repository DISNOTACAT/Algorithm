import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  /*
  2N+1 개의 줄로 입력
  N개의 차량
  N개의 들어가는 순서
  N개의 나오는 순서
  추월 차량이 몇대인지 출력

  4 3 2 1 ->
  -> 4 3 2 1 아무도 추월하지 않음

  4 3 2 1 ->
  -> 4 2 1 3 : 3 하나 추월 (뒤에 자신보다 작은 숫자가 있음

  d c b a -> b c' a d'
  <4, 3, 2, 1>
  [2, 3, 1, 4]

   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int answer = 0;

    Map<String, Integer> inMap = new HashMap<>();
    for(int i = 0; i < N; i++) {
      inMap.put(br.readLine(), i);
    }

    int[] outMap = new int[N];

    for(int i = 0; i < N; i++) {
      outMap[i] = inMap.get(br.readLine());
    }

    for(int i = 0; i < N; i++) {
      int car = outMap[i];

      for(int j = i+1; j < N; j++) {
        if(outMap[j] < car) {
          answer++;
          break;
        }
      }
    }


    System.out.println(answer);
  }
}
