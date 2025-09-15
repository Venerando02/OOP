/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevaccini;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class PuntoVaccinazione 
{
    private String id;
    private String nomeStruttura;
    private String indirizzo;
    private String regione;
    private int numMaxVaccinazioniGiornaliere;
    private List<PersonaPrenotata> listaPrenotati;
    
    public PuntoVaccinazione(String id, String nomeStruttura, String indirizzo, String regione, int numMaxVaccinazioniGiornaliere)
    {
        this.id = id;
        this.nomeStruttura = nomeStruttura;
        this.indirizzo = indirizzo;
        this.regione = regione;
        this.numMaxVaccinazioniGiornaliere = numMaxVaccinazioniGiornaliere;
        listaPrenotati = new LinkedList<PersonaPrenotata>();
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getRegione()
    {
        return regione;
    }
    
    public String toString()
    {
        String stringa = "PUNTO VACCINAZIONE [" + id + ", " + nomeStruttura + ", " + indirizzo + ", " + regione + ", " + numMaxVaccinazioniGiornaliere + "]\n\n";
        for(PersonaPrenotata pp: listaPrenotati)
        {
            stringa += pp.toString();
        }
        return stringa;
    }
    
    public void inserisciPrenotato(PersonaPrenotata pp)
    {
        listaPrenotati.add(pp);
    }
    
    public boolean isFull()
    {
        return (numMaxVaccinazioniGiornaliere == listaPrenotati.size());
    }
    
    public int eliminaPrenotati(int eta)
    {
        int cont = 0;
        for(Iterator<PersonaPrenotata> it = listaPrenotati.iterator(); it.hasNext(); )
        {
            if(it.next().getEta() < eta)
            {
                it.remove();
                cont++;
            }
        }
        return cont;
    }
    
    public int getNumPersoneVaccinate()
    {
        return listaPrenotati.size();
    }
    
    public float getEtaMedia()
    {
        int contEta = 0;
        
        for(PersonaPrenotata pp : listaPrenotati)
        {
            contEta += pp.getEta();
        }
        
        float etaMedia = ((float)contEta / (float)listaPrenotati.size());
        return etaMedia;
    }
    
}
