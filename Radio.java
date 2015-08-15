import java.util.*;
public class Radio{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      String s = k.nextLine();
      long n, m;
      while(!s.equals("")){
         String[] arr = s.split(" ");
         n = Long.parseLong(arr[0]);
         m = Long.parseLong(arr[1]);
         System.out.println(mod(fib(n), m));
         s = k.nextLine();
         
      }
      
  
      
   }
   
    public static long mod(long num, long m){
      return num%(long)(Math.pow(2,m));
    }
     
     
    public static long fib(long n){
      if(n==0)
         return 0;
       else if(n==1)
         return 1;
       else{
         
      long a  = 0; long b = 1; long ans = 0;
      for(int i= 0; i<n-1;i++){
        ans = a + b;
        a = b;
        b = ans;
      }
            return ans;
      }
    }
    
    
      
   }

