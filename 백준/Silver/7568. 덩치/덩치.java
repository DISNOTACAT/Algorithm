import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] weight = new int[n];
    int[] height = new int[n];
    int[] order = new int[n];

    StringTokenizer st;
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      weight[i] = w;
      height[i] = h;
      order[i]++;
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(weight[i] < weight[j] && height[i] < height[j]) {
          order[i]++;
        }
      }
    }

    for(int i : order){
      System.out.print(i + " ");
    }
  }
}
