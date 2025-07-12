import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static int[]  fences;
  private static double[]  dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    dp = new double[1<<(N+1)]; // 비트마스킹을 캐싱하는 dp 생성

    fences = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(fences);

    System.out.printf("%.10f\n", solution(0,0));
  }

  private static double solution(int index, int bitMask) {

    if(index >= fences.length) return 0;

    if(dp[bitMask] > 0) return dp[bitMask];

    double maxArea = solution(index+1, bitMask);

    for (int i = 0; i < fences.length; i++) {
      for (int j = i + 1; j < fences.length; j++) {
        for (int k = j + 1; k < fences.length; k++) {

          if (((bitMask & (1 << i)) == 0) &&
              ((bitMask & (1 << j)) == 0) &&
              ((bitMask & (1 << k)) == 0) &&  // 3개의 울타리가 모두 사용된 적 없으면
              (fences[i] + fences[j] > fences[k])) { // 삼각형의 조건을 통과하면

            double newArea = getArea(fences[i], fences[j], fences[k]);
            int newBitMask = bitMask | (1 << i) | (1 << j) | (1 << k); // 울타리 사용 기록
            maxArea = Math.max(maxArea,
                newArea + solution(index, newBitMask)); // 현시점으로 부터 다른 울타리를 사용한 최대 값을 가지고 옮
          }
        }
      }
    }
    return dp[bitMask] = maxArea;
  }

  private static double getArea(double A, double B, double C) {
    double p = (A + B + C) / 2.0;
    return Math.sqrt(p * (p - A) * (p - B) * (p - C));
  }

}
