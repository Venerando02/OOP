/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestioneagenziaassicurazione;

/**
 *
 * @author Venerando
 */
public class GestioneAgenziaAssicurazione 
{
    public static void main(String[] args) 
    {
        CompagnieAssicurative ca = new CompagnieAssicurative();
        ThreadInterattivo ti = new ThreadInterattivo(ca);
        ThreadReport tr = new ThreadReport(ca);
        
        tr.setDaemon(true);
        ti.start();
        tr.start();
    }    
}
