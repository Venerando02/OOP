/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenditabiglietti;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
   private Eventi e;
   
   public ThreadReport(Eventi e)
   {
       this.e = e;
   }
   
   public void run()
   {
       try
       {
           while(true)
           {
               e.creaReport2();
               Thread.sleep(5000);
           }
       }
       catch(InterruptedException e)
       {
           System.out.println("Errore sul thread.");
           System.exit(-1);
       }
   }
}
