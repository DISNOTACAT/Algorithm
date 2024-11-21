import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[size];

        for(int i = 0; i < size; i++) {
            String tmp = new StringTokenizer(br.readLine()).nextToken();
            map.put(tmp, i);
            arr[i] = tmp;
        }

        for(int i = 0; i < map.size(); i++) {

            String reverseKey = new StringBuilder(arr[i]).reverse().toString();

            if(map.containsKey(reverseKey)) {

                int length = reverseKey.length();
                System.out.println(length + " " + reverseKey.charAt((length-1)/2));
                break;
            }
        }

        long end = System.currentTimeMillis();
//        System.out.println("수행시간: " + (end - start) + " ms");

        br.close();
        bw.flush();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
