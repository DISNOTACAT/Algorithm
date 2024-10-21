import java.io.*;
import java.util.StringTokenizer;

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double sum = 0;
        double cnt = 0;
        int idx = 0;

        while(idx < 20){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            switch(st.nextToken()){
                case "A+" : sum += score * 4.5; cnt += score; break;
                case "A0" : sum += score * 4.0; cnt += score; break;
                case "B+" : sum += score * 3.5; cnt += score; break;
                case "B0" : sum += score * 3.0; cnt += score; break;
                case "C+" : sum += score * 2.5; cnt += score; break;
                case "C0" : sum += score * 2.0; cnt += score; break;
                case "D+" : sum += score * 1.5; cnt += score; break;
                case "D0" : sum += score; cnt += score; break;
                case "F" : cnt += score; break;
                default: break;
            }

            idx ++;
        }

        System.out.println(sum/cnt);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
