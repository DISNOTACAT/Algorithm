import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] white = new int[6];
        for(int i = 0; i < white.length; i++){
            white[i] = (Integer.parseInt(st.nextToken()) - chess[i]) * -1;
        }

        for(int i : white){
            System.out.print(i + " ");
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
