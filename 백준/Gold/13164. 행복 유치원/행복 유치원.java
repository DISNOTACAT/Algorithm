import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  /*
  1, 3,   5,   6,  10 -> 3그룹으로 묶기
   [2] [2]  [1]  [4]  -> 사이 간격의 값
   여기서 큰 수를 제거해서 (그룹수-1)개로 남길 때의 최소값
   sort 하고 앞에서 sum 한다.
   */
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int N = input[0]; // 인원수
    int K = input[1]; // 그룹수

    int[] kids =  Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();
    int[] gap = new int[N-1]; // 키차이를 저장하는 배열

    for(int i = 1; i < N; i++) {
      gap[i-1] = kids[i] - kids[i-1];
    }

    if(K == 1) {
      System.out.println(Arrays.stream(gap).sum());
      return;
    }

    if(K==N) {
      System.out.println(0);
      return;
    }

    Arrays.sort(gap);
    int answer = 0;
    for(int i = 0; i < N-K; i++) {
      answer += gap[i];
    }

    System.out.println(answer);
  }
}
