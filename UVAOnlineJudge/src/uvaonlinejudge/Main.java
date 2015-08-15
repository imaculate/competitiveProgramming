/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uvaonlinejudge;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Main {
    
    public static void main(String[] args){
        Scanner k  = new Scanner(System.in);
        String s ,in= "";
        String out = "";
        while(true){
            s = k.nextLine(); 
              if(s.equals("")) break;
             in += s+"\n";
       
            
        }
             boolean open = true; 
        for(int i = 0; i< in.length(); i++){
                 if(in.charAt(i)== '"' && open ){
                     out+= "``";
                     open = false;
                 }else if(in.charAt(i)== '"' && !open){
                      out+= "''";
                     open = true;
                 }else{
                      out+= in.charAt(i);
                  
                 }
             }
        System.out.println(out);
        System.exit(0);
        
    }
}
