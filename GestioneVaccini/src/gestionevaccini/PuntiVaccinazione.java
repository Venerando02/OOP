/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevaccini;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class PuntiVaccinazione 
{
    private List<PuntoVaccinazione> listaPuntiVaccinazione;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    private String PuntoVaccinazioneMaxEtaMedia;
    
    public PuntiVaccinazione()
    {
        listaPuntiVaccinazione = new LinkedList<PuntoVaccinazione>();
    }
    
    public void stampaTutto()
    {
        for(PuntoVaccinazione pv: listaPuntiVaccinazione)
        {
            System.out.println(pv.toString());
        }
    }
    
    public void creaReport()
    {
        float max = 0, tmp;
        PuntoVaccinazioneMaxEtaMedia = "";
        for(PuntoVaccinazione pp: listaPuntiVaccinazione)
        {
            tmp = pp.getEtaMedia();
            if(tmp > max)
            {
                max = tmp;
                PuntoVaccinazioneMaxEtaMedia = pp.getID();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("Il punto di vaccinazione con l'eta' media più alta e': " + PuntoVaccinazioneMaxEtaMedia);
    }
    
    public void caricaPuntiVaccinazione(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String id;
            String nomeStruttura;
            String indirizzo;
            String regione;
            int numMaxVaccinazioniGiornaliere;
            
            id = fp.readLine();
            while(id != null)
            {
                nomeStruttura = fp.readLine();
                indirizzo = fp.readLine();
                regione = fp.readLine();
                numMaxVaccinazioniGiornaliere = Integer.parseInt(fp.readLine());
                
                listaPuntiVaccinazione.add(new PuntoVaccinazione(id, nomeStruttura, indirizzo, regione, numMaxVaccinazioniGiornaliere));
                id = fp.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.\n");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);
        }
    }
    
    public int eliminaPrenotati(int eta)
    {
        int cont = 0;
        for(PuntoVaccinazione pv : listaPuntiVaccinazione)
        {
            cont += pv.eliminaPrenotati(eta);
        }
        return cont;
    }
    
    public void stampaNumTotalePrenotati(String regione)
    {
        int cont = 0;
        for(PuntoVaccinazione pp: listaPuntiVaccinazione)
        {
            if(pp.getRegione().equals(regione))
            {
                cont += pp.getNumPersoneVaccinate();
            }
        }
        System.out.println("Nella regione " + regione + " ci sono " + cont + " persone prenotate.");
    }
    
    public void caricaPrenotati(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
    
            String nome;
            String idPuntoVaccinazione;
            String cf;
            int eta;
            
            nome = fp.readLine();
       
            while(nome != null)
            {
                idPuntoVaccinazione = fp.readLine();
                cf = fp.readLine();
                eta = Integer.parseInt(fp.readLine());
                
                for(PuntoVaccinazione pv : listaPuntiVaccinazione)
                {
                    if((idPuntoVaccinazione.equals(pv.getID())) && (!pv.isFull()))
                    {
                        pv.inserisciPrenotato(new PersonaPrenotata(nome, cf, eta));
                        break;
                    }
                }
                
                nome = fp.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.\n");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);
        }
    }
}
