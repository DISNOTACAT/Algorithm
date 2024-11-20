import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] clock = new int[2];
        clock[0] = Integer.parseInt(st.nextToken());
        clock[1] = Integer.parseInt(st.nextToken());

        int duration = Integer.parseInt(br.readLine());
        int duration_time = duration / 60;
        int duration_minute = duration % 60;

        if(duration_time > 0) {
            clock[0] += duration_time;
        }

        if(duration_minute + clock[1] > 59) {
            clock[0]++;
            clock[1] += duration_minute - 60;
        } else {
            clock[1] += duration_minute;
        }

        if(clock[0] > 23) clock[0] -= 24;

        System.out.println(clock[0] + " " + clock[1]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
