/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typecheck;

/**
 *
 * @author GUNJAN
 */
import java.*;
import static jdk.nashorn.internal.objects.Global.print;

public class DynamicScope {
    
   public final int b = 5;
   
   public void foo(int b)
   {
    //int b=2;
    int a = b + 5;
    System.out.println("Value of b: " +b);
    System.out.println("Value of a: " +a);
   }
 
   public void foo1(int b)
  {
   
   System.out.println("Value of b: " +b);
   foo(b);
  }


//public class DynamicScope{
    public static void main(String args[]){
       DynamicScope d=new DynamicScope();
       System.out.println("Dynamic Scope");
       
       System.out.println("Foo()");
       d.foo(d.b);
       System.out.println("\nFoo1()");
       d.foo1(2);    
        
       
        
    }
}