import java.util.*;
public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
       String line = k.nextLine();
       int N = Integer.parseInt(line);
       for(int i = 0; i< N; i++){
         line = k.nextLine();
         String tagged  = preProcess(line);
         int n = tagged.length();
         int[] P  = new int[n];
         int R= 0; int C = 0; 
         for(int j = 1 ; j<n-1; j++){
          
    
             int j_mirror = 2*C - j;

            if (R > j)
                P[j] = Math.min(R - j, P[j_mirror]);
     
            
            
              
             while (tagged.charAt(j + (1 + P[j])) == tagged.charAt(j - (1 + P[j]))){ 
                P[j]++;
              }
 
              if (j + P[j] > R) {
                  C = j;
                  R = j + P[j];
               }
            
         }
         
         int max = 0;
         for(int w = 0; w<n; w++){
            max = (P[w] > max)?P[w]:max;
         }
         System.out.println(max);
       }
   }
   
   private static String preProcess(String in){
   
      in = in.toUpperCase();
      String ret = "$#";
      for(int i = 0; i< in.length(); i++){
         ret+= (char)in.charAt(i) + "#";
      }
       ret+= "@";
      return ret;
   }
}