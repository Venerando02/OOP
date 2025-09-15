/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compravenditaoggetti;

/**
 *
 * @author Venerando
 */
public class CompravenditaOggetti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        GestioneCategorie gc = new GestioneCategorie();
        ThreadInterattivo ti = new ThreadInterattivo(gc);
        ThreadReport tr = new ThreadReport(gc);
        tr.setDaemon(true);
        
        ti.start();
        tr.start();
        
    }
    
}
