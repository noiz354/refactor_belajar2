package norman.hackerrank;

public class Abbreviation {

 static String s = "abc";
 static String t = "ABC";

 public static void main(String[] args){
  calculateResult();

  s = "ABC";
  calculateResult();


  s = "Adbc";
  calculateResult();

  s = "eadbc";
  calculateResult();

  s = "edbc";
  calculateResult();

  s = "";
  calculateResult();

  s ="FYyxu";
  t ="FY";
  calculateResult();

  // testing character 
  System.out.println("character A "+isUpper('A'));
  System.out.println("character Z "+isUpper('Z'));
  System.out.println("character z "+isUpper('z'));
  System.out.println("character a "+isUpper('a'));
  System.out.println("convert d to D "+(char)toUpper('d'));
  System.out.println("convert d to D "+toUpper('d'));
 // testing character


 }

 private static void calculateResult() {
  boolean res = dp(s.length()-1, t.length()-1);
  System.out.println(String.format("\"%s\" convert to \"%s\" : \"%s\"", s, t, Boolean.toString(res)));
 }

 static boolean is_del = false;

 static boolean dp(int s_i, int t_i){

  if(s_i == -1 && t_i == -1)
   return true;
 
  if(s_i < 0 && t_i >= 0 && !is_del){
   return false;
  }else if(s_i < 0 && t_i >= 0 && is_del){
   return true;
  }
  if(isUpper(s.charAt(s_i))){
   if(s.charAt(s_i) == t.charAt(t_i)){
    if(is_del = (s_i-1 >= 0 && t_i-1 < 0))
     return true && dp(s_i-1, t_i);
    else
     return true && dp(s_i-1, t_i-1)|| dp(s_i-1, t_i);
   }else{
    /* tidak dapat dihapus, maka string s tidak dapat diubah ke t*/
    return false;
   }
  }else{
   if(toUpper(s.charAt(s_i)) == t.charAt(t_i)){
    if(is_del = (s_i-1 >= 0 && t_i-1 < 0)){
     return true && dp(s_i-1, t_i);
    }else {
      return true && dp(s_i - 1, t_i - 1) || dp(s_i-1, t_i);
    }
   }else{
    return dp(s_i-1, t_i);
   }
  }
 }

 static boolean dp2(int indexS, int indexT){
  if(!isWithinRange(indexT, 0, t.length()-1))
   return false;
  
  if(isUpper(s.charAt(indexS)) && s.charAt(indexS) == t.charAt(indexT)){
    dp(indexS-1,indexT-1);
  }else{
    if(toUpper(s.charAt(indexS)) == t.charAt(indexT)){
     dp(indexS-1, indexT-1);
    }else{
     dp(indexS-1, indexT);
    }
  }
  
  return false;
 }

 static boolean isWithinRange(int index, int start, int end){
  return index >= start && index <= end;
 }

 static boolean isUpper(char c){
  return c-65 >= 0 && c-65 <=25;
 }
 
 static int toUpper(int c){
  return c-32;
 }
}
