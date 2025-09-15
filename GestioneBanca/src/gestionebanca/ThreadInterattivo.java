/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionebanca;

import java.io.*;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread 
{

    private Clienti c;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public ThreadInterattivo(Clienti c) {
        this.c = c;
    }

    public int menu() {
        int scelta = 0;
        try {
            System.out.println("*****MENU*****");
            System.out.println("1. Elimina tutti i movimenti realizzati da un cliente in una certa data.");
            System.out.println("2. Stampare clienti che hanno realizzato addebiti maggiore di X.");
            System.out.println("3. Stampa report.");
            System.out.println("4. Stampa tutto.");
            System.out.println("5. Esci.");
            System.out.print("------> ");
            scelta = Integer.parseInt(tastiera.readLine());
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
            System.exit(-1);
        }
        return scelta;
    }

    public void run() {
        try {
            int scelta = 0;
            String nomeFileClienti;
            float importo;
            int filiale;
            String nomeFileMovimenti;
            String iban;
            String data;

            System.out.print("Inserisci la filiale da considerare: ");
            filiale = Integer.parseInt(tastiera.readLine());
            System.out.print("Inserisci il nome del file clienti: ");
            nomeFileClienti = tastiera.readLine();
            System.out.print("Inserisci il nome del file movimenti: ");
            nomeFileMovimenti = tastiera.readLine();

            c.caricaClienti(nomeFileClienti, filiale);
            c.caricaMovimenti(nomeFileMovimenti);

            while (scelta != 6) 
            {
                scelta = menu();
                switch (scelta) 
                {
                    case 1:
                        try 
                        {
                            System.out.print("Inserisci l'iban del cliente: ");
                            iban = tastiera.readLine();
                            System.out.print("Inserisci la data: ");
                            data = tastiera.readLine();
                            c.EliminaMovimenti(iban, data);
                        } 
                        catch (MovimentiNonEsistentiException e) 
                        {}
                        break;
                    case 2:
                        System.out.print("Inserisci un importo: ");
                        importo = Float.parseFloat(tastiera.readLine());
                        System.out.print("Inserisci una data: ");
                        data = tastiera.readLine();
                        c.stampaClienti(data, importo);
                        break;
                    case 3:
                        c.stampaReport();
                        break;
                    case 4:
                        c.stampaTutto();
                        break;
                    case 5:
                        return;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.print("FILE NON TROVATO.");
            System.exit(-1);
        }
        catch (IOException e)
        {
            System.out.print("ERRORE DI I/O.");
            System.exit(-2);
        }
    }

}
