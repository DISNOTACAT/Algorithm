import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = (br.readLine()).split(" ");
        
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int n = Integer.parseInt(str[2]);
        while(n --> 0) {
            a ^= b;
        }
        
        System.out.println(a);
    }
    
}