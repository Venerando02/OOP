/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compravenditaoggetti;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
   private GestioneCategorie gc;
   
   public ThreadReport(GestioneCategorie gc)
   {
     this.gc = gc;
   }
   
   public void run()
   {
     try
     {
       while(true)
       {
         gc.creaReport();  
         Thread.sleep(5000);
       }
     }
     catch(InterruptedException e)
     {
     }
   }    
}
