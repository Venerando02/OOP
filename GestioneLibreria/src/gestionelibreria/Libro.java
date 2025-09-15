/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelibreria;

/**
 *
 * @author Venerando
 */
public class Libro 
{
    private String codice; // CHIAVE
    private String tema;
    private String autore;
    private String titolo;
    private float prezzo;
    private String dataPubblicazione;
    private boolean disponibile;
    
    public Libro(String codice, String tema, String autore, String titolo, float prezzo, String dataPubblicazione, boolean disponibile)
    {
        this.codice = codice;
        this.tema = tema;
        this.autore = autore;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.dataPubblicazione = dataPubblicazione;
        this.disponibile = disponibile;
    }
    
    public String toString()
    {
        return "[" + codice + ", " + tema + ", " + autore + ", " + titolo + ", " + prezzo + ", " + dataPubblicazione + ", " + disponibile + "] \n"; 
    }
    
    public String getAutore()
    {
        return autore;
    }
    
    public float getPrezzo()
    {
        return prezzo;
    }
    
    public String getDataPubblicazione()
    {
        return dataPubblicazione;
    }
    
    public boolean equals(Object o)
    {
        return (prezzo == ((Libro)o).getPrezzo());
    }
    
}
