import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    solution();
  }

  public static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine()," ");
    long[] cards = new long[n];

    for(int i = 0; i < n; i++){
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards);

    for(int i = 0; i < m; i++){
      cards = cal(cards);
    }

    long sum = 0L;
    for(long i : cards){
      sum += i;
    }

    System.out.println(sum);
  }

  private static long[] cal(long[] cards) {

    long temp = cards[0] + cards[1];
    cards[0] = temp;
    cards[1] = temp;

    Arrays.sort(cards);

    return cards;

  }
}
