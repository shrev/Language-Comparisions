package LibraryFunction;

import java.util.Scanner;

public class Volume {
	
	public static void main(String[] args) {
		 
			  int edge;
		  	  Scanner input = new Scanner(System.in);
			  System.out.print("\nEnter the Edge Length : ");
			  edge = input.nextInt();
			 		 
			  float result  = (float) Math.pow(edge, 3);
			  System.out.println("Volume of Cube : "+result);
	}

}
