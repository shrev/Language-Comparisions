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

class big{
    public int x=5;
    
    public void f1()
    {
        int a=2+x;
        System.out.println("Value of a: " +a);
        
    }
    
    public void f2()
    {
        int x=3;
        System.out.println("Value of x: " +x);
        f1();
        
    }
}

class StaticScope{
    
    public static void main(String args[])
    {
        big b = new big();
        b.f1();
        b.f2();
    }
}