import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  // DFS 완전 탐색하며 만나기만 하면 Yes 반환

  private static List<ArrayList<Integer>> graph = new ArrayList<>();
  private static boolean[] gomgom;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int nodes = Integer.parseInt(st.nextToken());
    int edges = Integer.parseInt(st.nextToken());

    gomgom = new boolean[nodes+1];

    for(int i = 0; i <= nodes; i++) {
      graph.add(new ArrayList<Integer>());
    }

    while(edges-- > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      ArrayList<Integer> list = graph.get(start);
      list.add(end);
    }

    int G = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    while(G --> 0) {
      int gomNode = Integer.parseInt(st.nextToken());
      gomgom[gomNode] = true;
    }

    System.out.println(solution(1));
  }

  private static String solution(int start){

    if(gomgom[start]) {
      return "Yes";
    }

    ArrayList<Integer> next = graph.get(start);
    if(next.isEmpty()) {
      return "yes";
    }

    for(int i = 0; i < next.size(); i++) {

      int nextNode = next.get(i);
      if(!gomgom[nextNode] && solution(nextNode).equals("yes")) {
        return "yes";
      }
    }
    return "Yes";
  }

}
