/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneopere;

/**
 *
 * @author Venerando
 */
public class Opera 
{
    private int codiceOpera;
    private String nomeAutore;
    private String tipologia;
    private float stimaValore;
    
    public Opera(int codiceOpera, String nomeAutore, String tipologia, float stimaValore)
    {
        this.codiceOpera = codiceOpera;
        this.nomeAutore = nomeAutore;
        this.tipologia = tipologia;
        this.stimaValore = stimaValore;
    }
    
    public int getCodiceOpera()
    {
        return codiceOpera;
    }
    
    public String getTipologiaOpera()
    {
        return tipologia;
    }
    
    public float getValoreOpera()
    {
        return stimaValore;
    }
    
    public String getNomeAutore()
    {
        return nomeAutore;
    }
    
    public String toString()
    {
        return "[" + codiceOpera + "; " + nomeAutore + "; " + tipologia + "; " + stimaValore + "]\n";
    }
}
