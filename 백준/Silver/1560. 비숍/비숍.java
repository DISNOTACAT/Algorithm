import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BigInteger n = new BigInteger(br.readLine());
       BigInteger result = n.add(n).subtract(BigInteger.TWO);
       
       if(n.equals(BigInteger.ONE)) {
           result = BigInteger.ONE;
       }
      
       System.out.println(result);

   }
    
}