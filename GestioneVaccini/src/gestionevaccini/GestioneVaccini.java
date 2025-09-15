/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionevaccini;

/**
 *
 * @author Venerando
 */
public class GestioneVaccini 
{
    public static void main(String[] args) 
    {
        PuntiVaccinazione pv = new PuntiVaccinazione();
        ThreadInterattivo ti = new ThreadInterattivo(pv);
        ThreadReport tr = new ThreadReport(pv);
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }    
}
