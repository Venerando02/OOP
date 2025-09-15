/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionelineaproduzione;

/**
 *
 * @author Venerando
 */
public class GestioneLineaProduzione 
{
    public static void main(String[] args) 
    {
        Prodotti p = new Prodotti();
        ThreadInterattivo ti = new ThreadInterattivo(p);
        ThreadReport tr = new ThreadReport(p);
        
        tr.setDaemon(true);
        ti.start();
        tr.start();
    }    
}
