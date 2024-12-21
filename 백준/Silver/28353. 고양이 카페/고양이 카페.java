import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int cats = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[] catsArr = new int[cats];
        st = new StringTokenizer(br.readLine(), " ");
        for( int i = 0; i < cats; i++ ) {
            catsArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(catsArr);

        int leftIdx = 0;
        int rightIdx = (cats-1);
        int result = 0;

        while(rightIdx > leftIdx) {

            int total = catsArr[rightIdx] + catsArr[leftIdx];

            if(total <= weight) {
                leftIdx++;
                rightIdx--;
                result++;
            } else {
                rightIdx--;
            }
        }

        System.out.println(result);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }


}