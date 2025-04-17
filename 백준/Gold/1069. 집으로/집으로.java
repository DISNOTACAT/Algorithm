import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  /*
  거리보다 이전까지 점프하거나 넘어서 점프라하거나
   */

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int x = Integer.parseInt(input[0]);
    int y = Integer.parseInt(input[1]);
    double jumpDistance = Integer.parseInt(input[2]);
    int jumpTime = Integer.parseInt(input[3]);
    double answer = 0;

    double distanceToHome = Math.sqrt( Math.pow(x,2) + Math.pow(y,2));

    // 뜀거리와 집거리가 동일할 경우
    if(distanceToHome == jumpDistance) {
      System.out.println(Math.min(distanceToHome, jumpTime));
      return;
    }

    // 집 전까지 뛸 수 있는 점프
    int jumpCount = (int) (distanceToHome/jumpDistance);

    // 점프를 집 전까지만 하는 경우
    answer = (jumpTime * jumpCount) + (distanceToHome - (jumpDistance * jumpCount));

    // 점프를 한 번 더 해서 집까지 돌아오는 경우
    double plusJumpResult = (jumpTime * (jumpCount+1)) + ((jumpDistance * (jumpCount+1) - distanceToHome));
    answer = Math.min(answer, plusJumpResult);

    // 점프를 한 번 더 해서 홀인원
    if(jumpCount > 0) {
      answer = Math.min(answer, (jumpTime * (jumpCount+1)));
    } else {
      answer = Math.min(answer, (jumpTime * 2));
    }

    // 점프를 활용한 경우들과 그냥 걸어가는 경우를 최종 비교
    System.out.println(Math.min(answer, distanceToHome));
  }
}
