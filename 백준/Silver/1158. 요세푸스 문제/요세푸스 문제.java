import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i < n + 1; i++){
            list.add(i);
        }

        int index = 0;

        while(list.size() > 0){

            index = (index + (k-1)) % list.size();
            answer.add(list.get(index));
            list.remove(index);

        }

            System.out.print("<");
        for(int i = 0; i < answer.size() - 1; i++){
            System.out.print(answer.get(i) + ", ");
        }
            System.out.print(answer.get(answer.size() - 1) + ">");


        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
