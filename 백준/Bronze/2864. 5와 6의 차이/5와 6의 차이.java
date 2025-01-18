import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    solution();
  }

  public static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    String five = str.replaceAll("5", "6");
    String six = str.replaceAll("6", "5");

    StringTokenizer st = new StringTokenizer(five, " ");
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(six, " ");
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());


    System.out.println((c+d) + " " + (a+b));
  }
}
