/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenditabiglietti;
import java.io.*;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Eventi 
{ 
    private List<Evento> listaEventi;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    private List<Prenotazione> nuovaListaPrenotazione;
    private List<Evento> nuovaListaEventiPostiDisponibili;
    
    public Eventi()
    {
        listaEventi = new LinkedList<Evento>();
    }
    
    public boolean eventoEsistente(String idEvento)
    {
        for(Evento e: listaEventi)
        {
            if(e.getIDEvento().equals(idEvento))
                return true;
        }
        return false;
    }
    
    public void stampaTutto()
    {
        for(Evento e: listaEventi)
        {
            System.out.println(e.toString());
        }
    }
    
    public void caricaEventi(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String idEvento;
            String descrizione;
            String data;
            String luogo;
            float costoPersona;
            int numMaxPersone, cont = 0;
            
            idEvento = fp.readLine();
            
            while(idEvento != null)
            {
                descrizione = fp.readLine();
                data = fp.readLine();
                luogo = fp.readLine();
                costoPersona = Float.parseFloat(fp.readLine());
                numMaxPersone = Integer.parseInt(fp.readLine());
                
                if(listaEventi.add(new Evento(idEvento, descrizione, data, luogo, costoPersona, numMaxPersone)))
                    cont++;
                idEvento = fp.readLine();
            }
            System.out.println("Sono stati caricati: " + cont + " eventi.");
            fp.close();
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.\n");
            System.exit(-1);
        }
    }
    
    public void caricaPrenotazioni(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String idEvento;
            String nomeCompleto;
            String codiceFiscale;

            int cont = 0;

            idEvento = fp.readLine();
            
            while(idEvento != null)
            {
                nomeCompleto = fp.readLine();
                codiceFiscale = fp.readLine();
                
                for(Evento e: listaEventi)
                {
                    if(e.getIDEvento().equals(idEvento))
                    {
                        if(e.inserisciPrenotazione(new Prenotazione(nomeCompleto, codiceFiscale)))
                        {
                            cont++;
                            break;
                        }
                    }
                }
                
                idEvento = fp.readLine();
            }
            System.out.println("Sono stati caricati: " + cont + " prenotazioni.");
            fp.close();
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.\n");
            System.exit(-1);
        }
    }
    
    public void inserisciEvento() throws EventoGiaPresenteInListaException
    {
        try
        {
            String idEvento;
            String descrizione;
            String data;
            String luogo;
            float costoPersona;
            int numMaxPersone;

            System.out.print("id: ");
            idEvento = tastiera.readLine();
            System.out.print("descrizione: ");
            descrizione = tastiera.readLine();
            System.out.print("data: ");
            data = tastiera.readLine();
            System.out.print("luogo: ");
            luogo = tastiera.readLine();
            System.out.print("costo persona: ");
            costoPersona = Float.parseFloat(tastiera.readLine());
            System.out.print("numero max persone: ");
            numMaxPersone = Integer.parseInt(tastiera.readLine());
            
            if(eventoEsistente(idEvento) == false)
            {
                listaEventi.add(new Evento(idEvento, descrizione, data, luogo, costoPersona, numMaxPersone));
            }
            else
                throw new EventoGiaPresenteInListaException();
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.");
            System.exit(-1);
        }
    }
    
    public void inserisciNuovaPrenotazione(String idEvento) throws NumeroMassimoPersonePrenotateException
    {
        try
        {
            String nomeCompleto;
            String codiceFiscale;
            
            System.out.print("nome completo: ");
            nomeCompleto = tastiera.readLine();
            System.out.print("codice fiscale: ");
            codiceFiscale = tastiera.readLine();
            
            for(Evento e : listaEventi)
            {
                if((e.getIDEvento().equals(idEvento)) && (!e.isFull()))
                {
                    if(e.inserisciPrenotazione(new Prenotazione(nomeCompleto, codiceFiscale)))
                    {
                        System.out.println("\nPrenotazione inserita correttamente.");
                    }
                }
                else if((e.getIDEvento().equals(idEvento)) && (e.isFull()))
                    throw new NumeroMassimoPersonePrenotateException();
            }
            
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.");
            System.exit(-1);            
        }
    }
    
    public void cancellaEvento(String idEvento)
    {
        nuovaListaPrenotazione = new LinkedList<Prenotazione>();
        float perditaEconomica = 0.0F;
        for(Iterator<Evento> it = listaEventi.iterator(); it.hasNext(); )
        {
            Evento e = it.next();
            if(e.getIDEvento().equals(idEvento))
            {
                perditaEconomica += e.spostaPersoneInUnaNuovaLista(nuovaListaPrenotazione);
                it.remove();
            }
        }
        
        System.out.println("La perdita economica totale e' stata di: " + perditaEconomica);
    }
    
    public void stampaEventiPrenotazionePersona(String codiceFiscale)
    {
        for(Evento e: listaEventi)
        {
            e.stampaEventiPrenotazionePersona(codiceFiscale);
        }
    }
    
    public void stampaReport1()
    {
        for(Evento e: listaEventi)
        {
            e.calcolaRicavoEvento();
        }
    }
    
    public void creaReport2()
    {
        nuovaListaEventiPostiDisponibili = new LinkedList<Evento>();
        
        for(Evento e: listaEventi)
        {
            if(!e.isFull())
            {
                nuovaListaEventiPostiDisponibili.add(e);
            }
        }
    }
    
    public void stampaReport3()
    {
        for(Evento e: listaEventi)
        {
            e.calcolaNumPrenotati();
        }
    }
    
    public void stampaReport()
    {
        stampaReport1();
        System.out.println("\nNUOVA LISTA\n");
        for(Evento e: nuovaListaEventiPostiDisponibili)
        {
            System.out.println(e.toString());
        }
        System.out.println("\n");
        stampaReport3();
    }
    
    
}
