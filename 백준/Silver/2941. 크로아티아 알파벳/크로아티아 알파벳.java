import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (str.contains("c=")){
            str = str.replace("c=", ",");
        }
        if (str.contains("c-")){
            str = str.replace("c-", ",");
        }
        if (str.contains("dz=")){
            str = str.replace("dz=", ",");
        }
        if (str.contains("z=")){
            str = str.replace("z=", ",");
        }
        if (str.contains("d-")){
            str = str.replace("d-", ",");
        }
        if (str.contains("lj")){
            str = str.replace("lj", ",");
        }
        if (str.contains("nj")){
            str = str.replace("nj", ",");
        }
        if (str.contains("s=")){
            str = str.replace("s=", ",");
        }
        System.out.println(str.length());
    }
}