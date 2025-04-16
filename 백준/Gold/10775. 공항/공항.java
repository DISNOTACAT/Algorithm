import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  private static int[] gateNode;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int gates = Integer.parseInt(br.readLine());
    int planes = Integer.parseInt(br.readLine());

    gateNode = new int[gates+1];
    for(int i = 0 ; i <= gates; i++){
      gateNode[i] = i;
    }

    int result = 0;
    while(planes-- > 0) {
      int g = Integer.parseInt(br.readLine());

      int availableGate = find(g);
      if(availableGate == 0) break;

      union(availableGate, availableGate-1);
      result++;
    }

    System.out.println(result);
  }

  private static void union(int g, int h) {
    g = find(g);
    h = find(h);
    gateNode[g] = gateNode[h];
  }

  private static int find(int g) {
    if(gateNode[g] == g) return g;
    return gateNode[g] = find(gateNode[g]);
  }

}
