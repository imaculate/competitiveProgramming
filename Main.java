import java.util.*;

public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      
      long b, p, m;
      String s = k.nextLine();
      while(!s.equals("")){
         b = Long.parseLong(s);
         p = k.nextLong();
         m = k.nextLong();
         System.out.println(mod(b,p,m));
         s = k.nextLine();
         
      }
      
   }
   
   public static long mod(long b,long p,long m){
   
      if(p==0)
         return 1;
       if(p%2==0)
         return (mod(b,p/2, m) * mod(b,p/2, m)) %m;
       else
         return (mod(b,p-1,m) * b%m)%m; 
      
   }

}