import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int screen = Integer.parseInt(st.nextToken());
    int basket = Integer.parseInt(st.nextToken());
    int amount = Integer.parseInt(br.readLine());

    int[] apples = new int[amount];
    for(int i = 0; i < amount; i++){
      apples[i] = Integer.parseInt(br.readLine());
    }

    /*
     사과의 위치가 바구니를 벗어나면 움직인다.
     1 1 0 0 0
     a 0 0 0 0

     0 0 0 1 1  사과 위치 - 바구니 오른쪽 위치 만큼 이동 (5-2 = 3)
     0 0 0 0 a

     0 0 1 1 0
     0 0 a 0 0

    사과 위치 (바구니 = 2)
     1 0 0 0 0 >> basket (0,1) if(b == 1 && a == 1) continue
     0 0 0 0 1 >> right? if(bR < a)
     0 0 1 0 0 >> left? if(bL > a)
     */

    // 초기 바구니 위치
    int left = 1;
    int right = basket;
    int total = 0;

    // 사과 받기 시작
    for(int i = 0; i < amount; i++){
      int move = 0;

      // 현재 바구니 위치로 들어오는 경우
      if(apples[i] <= right && apples[i] >= left){
        continue;
      }

      if(apples[i] < left){
        move = (left - apples[i]);
        left -= move;
        right -= move;
      } else if (apples[i] > right){
        move = (apples[i] - right);
        right += move;
        left += move;
      }

      total += move;
    }

    System.out.println(total);
  }

}
