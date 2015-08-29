import java.util.*;
public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      String line = k.nextLine();
      
      int A = 0;
      int S = 0;
      while(!line.equals("-1")){
         String[] sarr = line.split(" ");
         A = Integer.parseInt(sarr[1]);
         if(A>=20 && A< 30){
            
            S = Integer.parseInt(sarr[2]);
            if(S>400000 && A<= 800000){
               
               System.out.println(sarr[0]);
            }
         }
         line = k.nextLine();
      }
   }
   
}