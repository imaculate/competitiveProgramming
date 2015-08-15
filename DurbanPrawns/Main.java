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
         String[] linearr;
         for(int j = 0; j< roaches; j++){
            line  = k.nextLine();
            linearr = line.split(" "); 
             x = Integer.parseInt(linearr[0]);
             y =  Integer.parseInt(linearr[1]);
             z =  Integer.parseInt(linearr[2]);
              roach[x][y]  = z;  
            
             
         }
         
         
         for(int j = 0; j< 1025; j++){
            for(int m = 0; m< 1025; m++){
               int temp = roach[j][m];
               for(int n = 1; n<= strength; n++){
                  if( j+n<=1024){
                     killed[j+n][m] += temp;
                     if(m-n>=0){
                        killed[j+n][m-n] += temp;
                     }
                      if(m+n<=1024){
                        killed[j+n][m+n] += temp;
                     }
                  }
                  
                  if(j-n>=0 ){
                     killed[j-n][m] += temp;
                       if(m-n>=0){
                          killed[j-n][m-n] += temp;
                     }
                     if(m+n<=1024){
                        killed[j-n][m+n] += temp;
                     }
                  }
                  
                  if(m-n>=0){
                     killed[j][m-n] += temp;
                  }
                  if(m+n<=1024){
                     killed[j][m+n] += temp;
                  }
                  
                   
               }
            }
         }
         int max = 0;
         int maxx = 0;
         int maxy = 0;
        for(int j = 0; j< 1025; j++){
            for(int m = 0; m< 1025; m++){
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