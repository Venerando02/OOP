/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelineaproduzione;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
    private Prodotti p;
    
    public ThreadReport(Prodotti p)
    {
        this.p = p;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                p.creaReport();
                Thread.sleep(5000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Errore sul THREAD.\n");
            System.exit(-1);
        }
    }
}
