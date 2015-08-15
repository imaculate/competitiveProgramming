import java.util.*;
class Main{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      long tests = k.nextLong();
      for(int j = 0; j<tests; j++){
         int n = k.nextInt();
         long[] myArray = new long[n+1];
         myArray[1] = 2L ;
         if(n>=2){
             myArray[2] = 3L;
         }
         
         for(int  i= 3; i<=n; i++){
            myArray[i] = myArray[i-2] + myArray[i-1];
         }
         System.out.println("Scenario #"+ (j+1)+ ":");

         System.out.print(myArray[n]+ "\n\n");
   
        }
         
      }

   
}