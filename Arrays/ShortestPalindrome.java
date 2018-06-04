//How to append minimum numbers of characters in front of string to make it a palindrome
public class ShortestPalindrome{

public static void main(String[] args){

test();

}

public static void test(){
 String a = "ABcd";

 String b = "CBABCD";
System.out.println(getShortestStr(a));

System.out.println(getShortestStr(b));
}

public static String getShortestStr(String s){

if (s==null || s.length()==0){return s;}
String reverse = new StringBuilder(s).reverse().toString();
int len = s.length();
for(int i=0;i<len-1;i++){
if (reverse.substring(i,len).equals(s.substring(0,len-i))){return reverse.substring(0,i);}

}

return reverse;
}



}
