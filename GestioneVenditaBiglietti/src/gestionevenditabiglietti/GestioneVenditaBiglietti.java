/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionevenditabiglietti;

/**
 *
 * @author Venerando
 */
public class GestioneVenditaBiglietti 
{
    public static void main(String[] args)
    {
        Eventi e = new Eventi();
        ThreadInterattivo ti = new ThreadInterattivo(e);
        ThreadReport tr = new ThreadReport(e);
        
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }    
}
