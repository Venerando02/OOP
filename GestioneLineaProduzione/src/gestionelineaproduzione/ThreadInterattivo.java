/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelineaproduzione;
import java.io.*;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread 
{
    private Prodotti p;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    
    public ThreadInterattivo(Prodotti p)
    {
        this.p = p;
    }
    
    public int menu()
    {
        int scelta = 0;
        try
        {
            System.out.println("*****MENU*****");
            System.out.println("1. Stampa il prodotto con la resa maggiore.");
            System.out.println("2. Cancella le registrazioni di una certa data da tutti i prodotti.");
            System.out.println("3. Determina il peso complessivo dei pezzi prodotti in quella data di quel dato prodotto.");
            System.out.println("4. Crea Report.");
            System.out.println("5. Stampa tutto.");
            System.out.println("6. Esci.");
            System.out.print("-------> ");
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
            String nomeFileProdotti;
            String nomeFileRegistrazioni;
            int numPezzi;
            float pesoTot;
            String data;
            String id;
            
            System.out.print("Inserisci il nome file prodotti: ");
            nomeFileProdotti = tastiera.readLine();
            System.out.print("Inserisci il nome file registrazioni: ");
            nomeFileRegistrazioni = tastiera.readLine();
            System.out.print("Inserisci una quantita' in input di pezzi: ");
            numPezzi = Integer.parseInt(tastiera.readLine());
            
            p.caricaProdotti(nomeFileProdotti);
            p.caricaRegistrazioni(nomeFileRegistrazioni, numPezzi);
            
            while(scelta != 7)
            {
                scelta = menu();
                switch(scelta)
                {
                    case 1:
                        p.resaMaggiorePercentuale();
                        break;
                    case 2:
                        try
                        {
                            System.out.print("Inserisci la data: ");
                            data = tastiera.readLine();
                            p.EliminaRegistrazioniData(data);
                        }
                        catch(DataNonEsistenteException e){}
                        break;
                    case 3:
                        System.out.print("Inserisci l'id del prodotto: ");
                        id = tastiera.readLine();
                        System.out.print("Inserisci la data: ");
                        data = tastiera.readLine();
                        pesoTot = p.pesoTotale(data, id);
                        System.out.println("Il peso totale e': " + pesoTot);
                        break;
                    case 4:
                        p.stampaReport();
                        break;
                    case 5:
                        p.stampaTutto();
                        break;
                    case 6:
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
