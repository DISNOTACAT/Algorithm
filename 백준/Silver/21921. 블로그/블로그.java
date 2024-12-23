import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine()," ");
    int[] blog = new int[N];
    for(int i = 0; i < N; i++){
      blog[i] = Integer.parseInt(st.nextToken());
    }


    String result = "SAD";
    int visit = 0;
    int count = 1;

    int maxSum = 0;


    for(int i = 0; i < K; i++){
      maxSum += blog[i];
    }

    visit = maxSum;

    for(int i = K; i < N; i++){
      // sliding
      maxSum += blog[i];
      maxSum -= blog[i - K];

      // 새로운 큰 수 일 경우
      if(maxSum > visit){
        visit = maxSum;
        count = 1; // 초기화
      } else if(maxSum == visit){ // 동일한 큰 수 일 경우
        count++;
      }
    }




    System.out.println(visit == 0 ? result : visit);
    if( visit != 0) System.out.println(count);



    br.close();

  }




  public static void main(String[] args) throws IOException {

    solution();
  }

}
