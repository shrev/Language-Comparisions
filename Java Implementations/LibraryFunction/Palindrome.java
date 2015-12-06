package LibraryFunction;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] args) {
		 
			  
		  	  Scanner input = new Scanner(System.in);
			  System.out.print("\nEnter the String : ");
			  String str = input.nextLine();
			  String rev = new StringBuffer(str).reverse().toString();
			  if(str.compareTo(rev) == 0)
			  System.out.println("Palindrome.");
			  else
			  System.out.println("Not a Palindrome.");
	}	

}
