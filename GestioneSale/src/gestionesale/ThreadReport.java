/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesale;
import java.io.*;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
    Sale s;

    public ThreadReport(Sale s)
    {
        this.s = s;
    }
    
    public void run()
    {
      try
      {
          while(true)
          {
            s.stampaReport();
            Thread.sleep(5000);
          }
      }
      catch(InterruptedException e)
      {
      }
    }


}
