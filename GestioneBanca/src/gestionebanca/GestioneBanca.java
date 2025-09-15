/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionebanca;

/**
 *
 * @author Venerando
 */
public class GestioneBanca 
{
    public static void main(String[] args)
    {
        Clienti c = new Clienti();
        ThreadInterattivo ti = new ThreadInterattivo(c);
        ThreadReport tr = new ThreadReport(c);
        
        tr.setDaemon(true);
        ti.start();
        tr.start();
    }   
}
