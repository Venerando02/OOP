/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelibreria;

/**
 *
 * @author Venerando
 */
public class ThreadReport extends Thread 
{
    Scaffali s;

    public ThreadReport(Scaffali s) 
    {
        this.s = s;
    }
    
    public void run()
    {
        try
        {
            while(true)
            {
                s.creaReport();
                Thread.sleep(5000);
            }
        }
        catch(InterruptedException e)
        {
        }
    }
}
