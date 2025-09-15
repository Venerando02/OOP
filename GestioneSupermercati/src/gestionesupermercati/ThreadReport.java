/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesupermercati;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
    private Clienti c;

    public ThreadReport(Clienti c) 
    {
        this.c = c;
    }
   
    public void run()
    {
        try
        {
            while(true)
            {
                c.creaReport();
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
