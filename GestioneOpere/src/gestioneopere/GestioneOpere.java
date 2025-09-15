/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestioneopere;
/**
 *
 * @author Venerando
 */
public class GestioneOpere 
{
    public static void main(String[] args)
    {
        Sale s = new Sale();
        ThreadInterattivo ti = new ThreadInterattivo(s);
        ThreadReport tr = new ThreadReport(s);
        
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }    
}
