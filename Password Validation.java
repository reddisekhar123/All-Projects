package sample1;
import java.util.Scanner;

public class PasswordValidation {
	
	
	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String a = sc.next();
	    int d = 0;
	    if (a.length() >= 8) {
	      if (a.contains("#") || a.contains("@") || a.contains("_")) {
	        char c = a.charAt(0);
	        //System.out.println(c);
	        if (Character.isAlphabetic(c)) {
	          char dd = a.charAt(a.length() - 1);
	          
	          if ((Character.isAlphabetic(dd)) || (Character.isDigit(dd)))
	          {
	            if (a.matches(".*[0-9]{1,}.*")
	                || a.matches(".*[a-zA-Z]{1,}.*")) {
	              System.out.println("Valid");
	            } else{
	              System.out.println("Not Valid");
	            }
	          } else{
	            System.out.println("Not Valid");
	          }
	        }
	         else{
	            System.out.println("Not Valid");
	          }
	      } else{
	        System.out.println("Not Valid");
	      }
	    } else{
	      System.out.println("Not Valid");
	    }
	  }

}
