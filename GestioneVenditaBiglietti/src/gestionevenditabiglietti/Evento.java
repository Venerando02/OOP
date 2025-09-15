/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenditabiglietti;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Evento 
{ 
    private String idEvento;
    private String descrizione;
    private String data;
    private String luogo;
    private float costoPersona;
    private int numMaxPersone;
    private List<Prenotazione> listaPrenotati;
    
    public Evento(String idEvento, String descrizione, String data, String luogo, float costoPersona, int numMaxPersone)
    {
        this.idEvento = idEvento;
        this.descrizione = descrizione;
        this.data = data;
        this.luogo = luogo;
        this.costoPersona = costoPersona;
        this.numMaxPersone = numMaxPersone;
        listaPrenotati = new LinkedList<Prenotazione>();
    }
    
    public String getIDEvento()
    {
        return idEvento;
    }
    
    public boolean inserisciPrenotazione(Prenotazione p)
    {
        return listaPrenotati.add(p);
    }
    
    public boolean isFull()
    {
        return (listaPrenotati.size() == numMaxPersone);
    }
    
    public String toString()
    {
        String stringa = "EVENTO [" + idEvento + "; " + descrizione + "; " + data + "; " + luogo + "; " + costoPersona + "; " + numMaxPersone + "]\n\n";
        for(Prenotazione p: listaPrenotati)
        {
            stringa += p.toString();
        }
        return stringa;
    }
    
    public float spostaPersoneInUnaNuovaLista(List<Prenotazione> listaNuovaPrenotazioni)
    {
        float perditaEconomica = 0.0F;
        int cont = 0;
        for(Iterator<Prenotazione> it = listaPrenotati.iterator(); it.hasNext(); )
        {
            Prenotazione p = it.next();
            if(listaNuovaPrenotazioni.add(p))
                cont++;
        }
        perditaEconomica = (float)(cont * this.costoPersona);
        return perditaEconomica;
    }
    
    public void stampaEventiPrenotazionePersona(String codiceFiscale)
    {
        for(Prenotazione p: listaPrenotati)
        {
            if(p.getCodiceFiscale().equals(codiceFiscale))
            {
                System.out.println("La persona " + codiceFiscale + " risulta prenotata all'evento: " + this.idEvento + ", " + this.descrizione + ".");
            }
        }
    }
    
    public void calcolaRicavoEvento()
    {
        float ricavoTot = (float)(listaPrenotati.size() * this.costoPersona);
        System.out.println("Per l'evento: " + idEvento + "; " + descrizione + " il ricavo totale e': " + ricavoTot);
    }
    
    public void calcolaNumPrenotati()
    {
        int numPrenotati = listaPrenotati.size();
        System.out.println("Per l'evento: " + idEvento + "; " + descrizione + " il numero di prenotati e': " + numPrenotati);
    }
}
