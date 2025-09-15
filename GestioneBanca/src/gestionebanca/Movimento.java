/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionebanca;

/**
 *
 * @author Venerando
 */
public class Movimento 
{
    private String iban; // CHIAVE
    private int tipologia;
    private String descrizione;
    private float importo;
    private String data; // AAAA/MM/GG
    
    public Movimento(String iban, int tipologia, String descrizione, float importo, String data)
    {
        this.iban = iban;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.importo = importo;
        this.data = data;
    }
    
    public String getIban()
    {
        return iban;
    }
    
    public String getData()
    {
        return data;
    }
    
    public String toString()
    {
        return "[" + tipologia + "; " + descrizione + "; " + importo + "; " + data + "]\n";
    }
    
    public float getImporto()
    {
        return importo;
    }
    
    /*public boolean equals(Object m)
    {
        return (iban.equals(((Movimento)m).getIban()) && data.equals(((Movimento)m).getData()));
    }*/
    
    public int getTipologia()
    {
        return tipologia;
    }
}
