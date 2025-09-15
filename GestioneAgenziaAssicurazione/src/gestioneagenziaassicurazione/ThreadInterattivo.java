/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneagenziaassicurazione;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread 
{
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    CompagnieAssicurative ca;
    
    public ThreadInterattivo(CompagnieAssicurative ca)
    {
        this.ca = ca;
    }
    
    public int menu()
    {
        int scelta = 0;
        try
        {
            System.out.println("******MENU'******");
            System.out.println("1. Stipula una nuova polizza.");
            System.out.println("2. Stampa la somma di tutte le rate.");
            System.out.println("3. Crea report.");
            System.out.println("4. Stampa tutto.");
            System.out.println("5. Esci.");
            System.out.print("------->  ");
            scelta = Integer.parseInt(tastiera.readLine());
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-1);
        }
        return scelta;
    }
    
    public void run()
    {
        try
        {
            int scelta = 0;
            String nomeFileClienti;
            String nomeFileCompagnieAssicurative;
            String nomeCompagnia;
            String cf, dataScadenza;
            float sommaTot = 0.0F;
            
            System.out.print("Inserisci il nome del file delle compagnie: ");
            nomeFileCompagnieAssicurative = tastiera.readLine();
            System.out.print("Inserisci il nome del file dei clienti: ");
            nomeFileClienti = tastiera.readLine();
            
            ca.caricaCompagnie(nomeFileCompagnieAssicurative);
            ca.caricaClienti(nomeFileClienti);
            
            while(scelta != 6)
            {
                scelta = menu();
                switch(scelta)
                {
                    case 1:
                        try 
                        {
                            System.out.print("Inserisci una compagnia: ");
                            nomeCompagnia = tastiera.readLine();
                            ca.inserisciNuovaPolizza(nomeCompagnia);
                        } 
                        catch (PolizzaAttivaSullaCompagniaException e)
                        {}
                        break;
                    case 2:
                        System.out.print("Inserisci il cf del cliente: ");
                        cf = tastiera.readLine();
                        System.out.print("Inserisci la data di scadenza: ");
                        dataScadenza = tastiera.readLine();
                        sommaTot = ca.stampaSommaRatePolizzeCliente(cf, dataScadenza);
                        System.out.println("La somma totale delle polizze per " + cf + " e': " + sommaTot);
                        break;
                    case 3:
                        ca.stampaReport();
                        break;
                    case 4:
                        ca.stampaTutto();
                        break;
                    case 5:
                        return;
                }
            }
                    
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.");
            System.exit(-1);        
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);        
        }
    }
}
