package ExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;

class Divide_By_Zero {
  public static void main(String[] args) {
 
  int a, b, result;
 
  // try block
  try {
	  Scanner input = new Scanner(System.in);
	  System.out.print("\nEnter the Dividend : ");
	  a = input.nextInt();
	  System.out.print("\nEnter the Divisor  : ");
	  b = input.nextInt();
 
	  result  = a / b;
	  System.out.println("\nResult of "+a+" divided by "+b+" is " + result+".");
  }
 
  // catch block
 catch (ArithmeticException e) {
    System.out.println("\nInside Catch Block -> Exception Caught : Division by Zero.");
  }

 catch (InputMismatchException aiex) {
	    System.out.println("\nInside Catch Block : Exception Caught: NaN.");
	  }
 
 // finally block
 finally {
	 System.out.println("\nInside Finally Block : If the division didn't work, you entered bad data.");
   }
  }
 }
