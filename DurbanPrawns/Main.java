import java.util.*;
public class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      String line = k.nextLine();
      int cases = Integer.parseInt(line);
      int[][] roach = new int [1025][1025];
      int[][] killed = new int [1025][1025];
      for(int i =0; i< cases; i++){
         int strength = Integer.parseInt(k.nextLine());
         int roaches = Integer.parseInt(k.nextLine());
         int x = 0;
         int y = 0;
         int z = 0;
         int minix  = Integer.MAX_VALUE;
         int miniy = Integer.MAX_VALUE;
         int maxix = 0;
         int maxiy  = 0;
         String[] linearr;
         for(int j = 0; j< roaches; j++){
            line  = k.nextLine();
            linearr = line.split(" "); 
            x = Integer.parseInt(linearr[0]);
            y =  Integer.parseInt(linearr[1]);
            z =  Integer.parseInt(linearr[2]);
            minix = Math.min(x, minix);
            miniy = Math.min(y, miniy);
            maxix = Math.max(x, minix);
            maxiy = Math.max(y, maxiy);
            roach[x][y]  = z; 
            for(int n = 1; n<= strength; n++){
               if( x+n<=1024){
                  killed[x+n][y] += z;
                  if(y-n>=0){
                     killed[x+n][y-n] += z;
                  }
                  if(y+n<=1024){
                     killed[x+n][y+n] += z;
                  }
               }
                  
               if(x-n>=0 ){
                  killed[x-n][y] += z;
                  if(y-n>=0){
                     killed[x-n][y-n] += z;
                  }
                  if(y+n<=1024){
                     killed[x-n][y+n] += z;
                  }
               }
                  
               if(y-n>=0){
                  killed[x][y-n] += z;
               }
               if(y+n<=1024){
                  killed[x][y+n] += z;
               }
                  
                   
            } 
            
             
         }
         
         
      
         
      int max = 0;
      int maxx = 0;
      int maxy = 0;
      for(int j = Math.max(minix-strength,0); j<= Math.min(1024,maxix+strength); j++){
         for(int m = Math.max(miniy-strength,0); m<=Math.min(1024, maxiy+strength); m++){
            if(killed[j][m]> max){
            
               max  = killed[j][m];
               maxx = j;
               maxy = m;
               
            }
         }
      }
      System.out.println(maxx + " "+ maxy + " "+ max);
      }         
   }
      
   
}