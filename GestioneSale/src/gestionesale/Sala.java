/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesale;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class Sala 
{
    private String nomeSala;
    private int codiceSala; // CHIAVE
    private String periodoStorico;
    private String collocazione;
    private List<Opera> listaOpere;
    
    public Sala(String nomeSala, int codiceSala, String periodoStorico, String collocazione)
    {
        this.nomeSala = nomeSala;
        this.codiceSala = codiceSala;
        this.periodoStorico = periodoStorico;
        this.collocazione = collocazione;
        listaOpere = new LinkedList<Opera>();
    }
    
    public void aggiungiOpera(Opera o)
    {
        listaOpere.add(o);
    }
    
    public int getCodiceSala()
    {
        return codiceSala;
    }
    
    public String toString()
    {
        String stringa = "[SALA: " + nomeSala + ", " + codiceSala + ", " + periodoStorico + ", " + collocazione + "]\n\nOPERA:\n";
        for(Opera o : listaOpere)
        {
            stringa += o.toString();
        }
        return stringa;
    }
    
    public boolean remove(int codiceSala, int codiceOpera)
    {
        return (listaOpere.remove(new Opera("", codiceSala, codiceOpera, "", 0.0F)));
    }
    
    public float valoreTotaleOpereAutore(String nomeAutore)
    {
        float valoreTotale = 0.0F;
        
        for(Opera o: listaOpere)
        {
            if(o.getNomeAutore().equals(nomeAutore))
                valoreTotale += o.getStimaValore();
        }
        
        return valoreTotale;
    }
    
    public int getNumeroOpere(String tipologia)
    {
        int numOpere = 0;
        for(Opera o : listaOpere)
        {
            if(o.getTipologia().equals(tipologia))
                numOpere++;
        }
        return numOpere;
    }
}
