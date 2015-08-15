import java.util.*;
 class Main{
    public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      String line = k.nextLine();
      String[] linearray = line.split(" ");
      int hotels = Integer.parseInt(linearray[2]);
      int weeks  = Integer.parseInt(linearray[3]);
      int budget = Integer.parseInt(linearray[1]);
      int people = Integer.parseInt(linearray[0]);
      long total = Integer.MAX_VALUE;
      
      for(int i =0; i< hotels; i++){
         String linecost = k.nextLine();
         int cost = Integer.parseInt(linecost);
         
        
         ArrayList<Integer> weekslist = new ArrayList<Integer>();
         for(int j = 0; j< weeks; j++){
            weekslist.add(k.nextInt());
            
         }
         
         k.nextLine();
         Collections.sort(weekslist);
         
         
         if(weekslist.get(weeks-1)>= people){
            long totaltemp = (long)people* (long)cost;
             total =( totaltemp<total)?totaltemp:total;

         }
        }
      if (total<=budget){
         System.out.println(total);
      }else{
         System.out.println("stay home");
      }



      
   }
}