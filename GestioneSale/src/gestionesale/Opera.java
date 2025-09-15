/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesale;

/**
 *
 * @author Venerando
 */
public class Opera
{
    private String nomeAutore;
    private int codiceSala;
    private int codiceOpera; // CHIAVE
    private String tipologia;
    private float stima;
    
    public Opera(String nomeAutore, int codiceSala, int codiceOpera, String tipologia, float stima)
    {
        this.nomeAutore = nomeAutore;
        this.codiceSala = codiceSala;
        this.codiceOpera = codiceOpera;
        this.tipologia = tipologia;
        this.stima = stima;
    }
    
    public String toString()
    {
        return "[" + nomeAutore + ", " + codiceSala + ", " + codiceOpera + ", " + tipologia + ", " + stima + "] \n";
    }
    
    public int getCodiceSala()
    {
        return codiceSala;
    }
    
    public int getCodiceOpera()
    {
        return codiceOpera;
    }
    
    public String getNomeAutore()
    {
        return nomeAutore;
    }
    
    public boolean equals(Object o)
    {
        return ((codiceSala == ((Opera)o).getCodiceSala()) && (codiceOpera == ((Opera)o).getCodiceOpera()));
    }
    
    public float getStimaValore()
    {
        return stima;
    }
    
    public String getTipologia()
    {
        return tipologia;
    }
}
