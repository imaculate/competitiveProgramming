import java.util.*;
public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      String line = k.nextLine();
      while(!line.equals("-1")){
         
         String[] sa = line.split(" ");
         String first = sa[0];
         String second = "";
         
         if(sa.length==2){
             second = sa[1];
         }else{
            second = k.nextLine();
         }
         System.out.println(distance(first, second));
         line = k.nextLine(); 
      }
   
   
   }
   
   private static int distance(String a, String b) {
       
      if(a.equals(b)){
         return 0;
      }
      int la = a.length();
      int lb = b.length();
      if(la == 0){
         return lb;
      }
      if(lb == 0){
         return la;
      }
     
      int [][] costs = new int [b.length() + 1][a.length() + 1];
      for (int j = 0; j < costs[0].length; j++)
         costs[0][j] = j*2;
      for (int i = 1; i <= b.length(); i++) {
           
         int n= i-1;
         costs[i][0] = 2*i;
         int nw;
         for(int j = 1; j<= a.length(); j++){
            int m=j-1;
            if(b.charAt(n)==a.charAt(m)){
               nw = costs[i-1][j-1];
            }
            else{
               nw = Math.min(costs[i-1][j]+2, costs[i][j-1]+2);
               nw = Math.min(nw,costs[i-1][j-1]+  ((Character.toUpperCase(b.charAt(n))==Character.toUpperCase(a.charAt(m)))?1:2));
            }
            costs[i][j] = nw;
         }
           
           
      }
      return costs[b.length()][a.length()];
   }
}