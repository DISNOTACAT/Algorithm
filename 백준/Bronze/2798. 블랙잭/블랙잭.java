import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] cards = new int[N];
    st = new StringTokenizer(br.readLine()," ");
    for(int i = 0; i < N; i++){
      cards[i] = Integer.parseInt(st.nextToken());
    }


    int sum = 0;
    for(int i = 0; i < N-2; i++){
      for(int j = i+1; j < N-1; j++){
        for(int k = j+1; k < N; k++){
          
          if(cards[i] + cards[j] + cards[k] <= M){
            sum = Math.max(sum, cards[i] + cards[j] + cards[k]);
          }
        }
      }
    }

    System.out.println(sum);
  }

}
