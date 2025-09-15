/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionelibreria;

/**
 *
 * @author Venerando
 */
public class GestioneLibreria 
{
    public static void main(String[] args)
    {
        Scaffali s = new Scaffali();
        ThreadInterattivo ti = new ThreadInterattivo(s);
        ThreadReport tr = new ThreadReport(s);
        
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }   
}
