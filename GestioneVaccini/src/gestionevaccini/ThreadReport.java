/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevaccini;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{

    PuntiVaccinazione pv;

    public ThreadReport(PuntiVaccinazione pv) 
    {
        this.pv = pv;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                pv.creaReport();
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
