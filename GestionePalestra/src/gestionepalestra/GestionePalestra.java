/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionepalestra;

/**
 *
 * @author Venerando
 */
public class GestionePalestra 
{
    public static void main(String[] args)
    {
        Discipline d = new Discipline();
        ThreadInterattivo ti = new ThreadInterattivo(d);
        ThreadReport tr = new ThreadReport(d);
        
        tr.setDaemon(true);
        ti.start();
        tr.start();
    }    
}
