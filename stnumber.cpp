#include <string>
#include <iostream>
#include <map>
using namespace std;
int main(){
   string name;
   String num;
   map<string, int> students ;
   getline(cin, name);
   while(name!=-1){
      num = getnum(name);
      if(!students.insert(pair<string, int>(name, 1))){
         students[name]++;
         
      }
       
       getline(cin, name);
   }
   
   string alpha; 
  
   for(int i = 0; i< students.size(); i++){
      alpha = students.get(i).first;
      for(int j = 0; j< students.;j++){
         printf(%s%3d, alpha, j-1);
      }
   }
}

string getnum(string name){
   string[] sa =  name.split(" ");
   string fname = sa[0];
   string lname = sa[1];
   string out = "";
   for(int i = 0; i< fname.length(); i++){
      char c = fname.charAt(i)
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
   
     for(int i = 0; i< lname.length(); i++){
      char ch = lname.charAt(i)
      if((c =='A' | c=='E' | c == 'I' | c== 'O' | c == 'U')) {
         out += c;
         if(out.length()== 6){
            break;
         }
         
      }
   }
   
   while(out.length()<6){
      out+= 'Z';
   }
   
}
