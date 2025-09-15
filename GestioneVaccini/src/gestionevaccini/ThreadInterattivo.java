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
public class ThreadInterattivo extends Thread 
{
    PuntiVaccinazione pv;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    
    public ThreadInterattivo(PuntiVaccinazione pv)
    {
        this.pv = pv;
    }
    
    public int menu()
    {
        int scelta = 0;
        try
        {
            System.out.println("******MENU******");
            System.out.println("1. Elimina persone data una eta'.");
            System.out.println("2. Stampa persone vaccinate in una regione.");
            System.out.println("3. Stampa report.");
            System.out.println("4. Stampa tutto.");
            System.out.println("5. Esci.");
            System.out.print("-------> ");
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
            String nomeFilePersone;
            String nomeFilePuntiVaccinazione;
            int eta, cont;
            
            String regione;
            
            System.out.print("Inserisci il nome del file punti di vaccinazione: ");
            nomeFilePuntiVaccinazione = tastiera.readLine();
            System.out.print("Inserisci il nome del file persone: ");
            nomeFilePersone = tastiera.readLine();
            
            pv.caricaPuntiVaccinazione(nomeFilePuntiVaccinazione);
            pv.caricaPrenotati(nomeFilePersone);
            
            while(scelta != 6)
            {
                scelta = menu();
                switch(scelta)
                {
                    case 1:
                        System.out.print("Inserisci una eta': ");
                        eta = Integer.parseInt(tastiera.readLine());
                        cont = pv.eliminaPrenotati(eta);
                        System.out.println("Sono stati eliminati " + cont + " prenotati.");
                        break;
                    case 2:
                        System.out.print("Inserisci il nome della regione: ");
                        regione = tastiera.readLine();
                        pv.stampaNumTotalePrenotati(regione);
                        break;
                    case 3:
                        pv.stampaReport();
                        break;
                    case 4:
                        pv.stampaTutto();
                        break;
                    case 5:
                        return;
                }
            }
        }
        catch(IOException e)
        {
           System.out.println("ERRORE DI I/O.");
           System.exit(-1);
        }
    }
    
}
