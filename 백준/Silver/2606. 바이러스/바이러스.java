import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] lst;
    static boolean[] check;
    static int result = 0;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int computerLine = Integer.parseInt(br.readLine());

        lst = new ArrayList[computerNum + 1];
        check = new boolean[computerNum + 1];

        for (int i = 1; i <= computerNum; i++) {
            lst[i] = new ArrayList<>();
        }

        for (int i = 1; i <= computerLine; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input, " ");

            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            lst[index].add(value);
            lst[value].add(index); // 해당 문제에서는 간선 방향에 대한 언급이 없었으므로 양방향이라고 간주하고 넣었다.
        }

        DFS(1);
        System.out.println(result);
    }

    static void DFS(int v){
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while(!stack.isEmpty()){
            int e = stack.pop();
            check[e] = true;

            for(int tmp : lst[e]){
                if(!check[tmp]){
                    check[tmp] = true;
                    stack.push(tmp);
                    result++;
                }
            }
        }
    }
}