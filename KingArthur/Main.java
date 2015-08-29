import java.util.*;
import java.math.*;
public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      
      String line = k.nextLine();
      
      String[] sarr = line.split(" "); 
      
      BigDecimal a, b, c, cosC, Area,SP;
      
      a = new BigDecimal(sarr[0]);
       b = new BigDecimal(sarr[1]);
       c = new BigDecimal(sarr[2]);
       
       cosC = ((a.multiply(a).add( b.multiply(b))).subtract(c.multiply(c))).divide(a.multiply(new BigDecimal("2")).multiply(b), 20, RoundingMode.HALF_UP);
       
       
       
       double angle = Math.acos(cosC.doubleValue());
       
       Area = a.multiply(b).multiply(new BigDecimal(Math.sin(angle)));
       SP = a.add(b).add(c);
       
       
       
      double r = Area.divide(SP,20, RoundingMode.HALF_UP).doubleValue();
      System.out.printf("The radius of the round table is: %,.3f%n", r);
   }
   
   
}