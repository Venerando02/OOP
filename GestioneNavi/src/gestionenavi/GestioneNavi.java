/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionenavi;

/**
 *
 * @author Venerando
 */
public class GestioneNavi 
{
    public static void main(String[] args) 
    {
        Navi n = new Navi();
        ThreadInterattivo ti = new ThreadInterattivo(n);
        ThreadReport tr = new ThreadReport(n);
        
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
    }    
}
