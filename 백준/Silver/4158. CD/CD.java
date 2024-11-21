import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {

            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sangeunSize = Integer.parseInt(st.nextToken());
            int sunyungSize = Integer.parseInt(st.nextToken());

            int total = sangeunSize + sunyungSize;
            if(total == 0) break;

            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < total; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            cnt += (total - set.size());
            System.out.println(cnt);

        }

        br.close();
        bw.flush();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}


