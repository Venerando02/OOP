/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionesale;

/**
 *
 * @author Venerando
 */
public class GestioneSale 
{
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Sale s = new Sale();
        ThreadInterattivo ti = new ThreadInterattivo(s);
        ThreadReport tr = new ThreadReport(s);
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }
}
