/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenditabiglietti;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread 
{
    private Eventi e;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    
    public ThreadInterattivo(Eventi e)
    {
        this.e = e;
    }
      
    public int menu()
    {
        int scelta = 0;
        try
        {
            System.out.println("\n******MENU'******");
            System.out.println("1. Inserisci un nuovo evento.");
            System.out.println("2. Inserisci una nuova prenotazione, dato l'id dell'evento.");
            System.out.println("3. Cancella un evento.");
            System.out.println("4. Stampa le prenotazioni.");
            System.out.println("5. Crea report.");
            System.out.println("6. Stampa tutto.");
            System.out.println("7. Esci.");
            System.out.print("-------->> ");
            scelta = Integer.parseInt(tastiera.readLine());
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.");
            System.exit(-1);
        }
        return scelta;
    }
    
    public void run()
    {
        try
        {
            int scelta = 0;
            String nomeFilePrenotazioni;
            String nomeFileEventi, idEvento, codiceFiscale;
            
            
            System.out.print("Inserisic il nome file eventi: ");
            nomeFileEventi = tastiera.readLine();
            System.out.print("Inserisic il nome file prenotazioni: ");
            nomeFilePrenotazioni = tastiera.readLine();
            
            e.caricaEventi(nomeFileEventi);
            e.caricaPrenotazioni(nomeFilePrenotazioni);
            
            while(scelta != 8)
            {
                scelta = menu();
                switch(scelta)
                {
                    case 1:
                        try 
                        {
                            e.inserisciEvento();
                        } 
                        catch (EventoGiaPresenteInListaException e)
                        {
                            System.out.println("Evento gia' esistente.\n");
                            System.exit(-1);
                        }
                        break;
                    case 2:
                        try 
                        {
                            System.out.print("Inserisci l'id evento: ");
                            idEvento = tastiera.readLine();
                            e.inserisciNuovaPrenotazione(idEvento);
                        }
                        catch (NumeroMassimoPersonePrenotateException e) 
                        {
                            System.out.println("Numero massimo di persone prenotabili superato.");
                            System.exit(-1);
                        }
                        break;
                    case 3:
                        System.out.print("Inserisci l'id evento: ");
                        idEvento = tastiera.readLine();
                        e.cancellaEvento(idEvento);
                        break;
                    case 4:
                        System.out.print("Inserisci il codice fiscale della persona: ");
                        codiceFiscale = tastiera.readLine();
                        e.stampaEventiPrenotazionePersona(codiceFiscale);
                        break;
                    case 5:
                        e.stampaReport();
                        break;
                    case 6:
                        e.stampaTutto();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Errore di I/O.");
            System.exit(-1);        
        }
    }
}
