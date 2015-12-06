/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication17;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RG Choukikar
 */
public class threadclass {
    public static void main(String args[])
    {
    example e = new example();
    e.start();
    
    }
}

class example extends Thread{

    
    @Override
    public void run()
    {
   // System.out.println("running the code");
    for(int i = 1;i<=5;i++)
    {
    System.out.println( "iteration");
        try {
            this.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}