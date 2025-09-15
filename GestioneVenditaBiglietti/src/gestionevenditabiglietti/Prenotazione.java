/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenditabiglietti;

/**
 *
 * @author Venerando
 */
public class Prenotazione 
{ 
    private String nomeCompleto;
    private String codiceFiscale;
    
    public Prenotazione(String nomeCompleto, String codiceFiscale)
    {
        this.nomeCompleto = nomeCompleto;
        this.codiceFiscale = codiceFiscale;
    }
    
    public String getNomeCompleto()
    {
        return nomeCompleto;
    }
    
    public String getCodiceFiscale()
    {
        return codiceFiscale;
    }
    
    public String toString()
    {
        return "[" + nomeCompleto + "; " + codiceFiscale + "]\n";
    }
}
