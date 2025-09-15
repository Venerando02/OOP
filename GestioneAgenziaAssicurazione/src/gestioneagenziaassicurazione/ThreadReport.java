/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneagenziaassicurazione;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
    CompagnieAssicurative ca;
    
    public ThreadReport(CompagnieAssicurative ca)
    {
        this.ca = ca;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                ca.creaReport();
                Thread.sleep(5000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("ERRORE SUL THREAD.");
            System.exit(-1);
        }
    }
    
}
