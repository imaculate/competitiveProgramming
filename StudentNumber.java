import java.util.*;


public class StudentNumber{
   public static void main(String[] args){
      String name;
      String num;
      Map<String,Integer> students = new HashMap<String, Integer>() ;
      Scanner k = new Scanner(System.in);
      name = k.nextLine();
      while(!name.equals("-1")){
         num = getnum(name);
         if(students.containsKey(num)){
            int index = students.get(num).intValue()+1;
            students.put(num, new Integer(index ));
            System.out.println(num+String.format("%03d", index));
         
         
         }
         else{
            students.put(num, 0);
             System.out.println(num+String.format("%03d", 0));
         }
       
         name = k.nextLine();
      }
   
 
   }

   public static String getnum(String name){
    
      String[] sa =  name.split(" ");
      String fname = sa[0];
      String lname = sa[1];
      String out = "";
      for(int i = 0; i< lname.length(); i++){
         char c = lname.charAt(i);
         if(!(c =='A' | c=='E' | c == 'I' | c== 'O' | c == 'U')) {
            out += c;
            if(out.length()== 4){
               break;
            }
         
         }
      }
   
      while(out.length()<4){
         out+= 'Z';
      }
   
      for(int i = 0; i< fname.length(); i++){
         char ch = fname.charAt(i);
         if((ch =='A' | ch=='E' | ch == 'I' | ch== 'O' | ch == 'U')) {
            out += ch;
            if(out.length()== 6){
               break;
            }
         
         }
      }
   
      while(out.length()<6){
         out+= 'Z';
      }
      return out;
   }
}

