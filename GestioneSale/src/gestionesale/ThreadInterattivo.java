/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesale;

import java.io.*;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread {

    Sale s;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

    public ThreadInterattivo(Sale s) {
        this.s = s;
    }

    public int menu() {
        int scelta = 0;
        try {
            System.out.println("*****MENU*****");
            System.out.println("1. Elimina una opera.");
            System.out.println("2. Stampa somma valore delle opere di un autore.");
            System.out.println("3. Crea Report.");
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
            String nomefileSale;
            String nomefileOpere;
            int codiceSala;
            int codiceOpera;
            String nomeAutore;
            float valoreTotaleOpere;

            System.out.print("Inserisci il nome del file di sale: ");
            nomefileSale = tastiera.readLine();
            System.out.print("Inserisci il nome del file di opere: ");
            nomefileOpere = tastiera.readLine();

            s.caricaSale(nomefileSale);
            s.caricaOpere(nomefileOpere);

            while (scelta != 6) {
                scelta = menu();
                switch (scelta) {
                    case 1:
                        try {
                            System.out.print("Inserisci il codice della sala: ");
                            codiceSala = Integer.parseInt(tastiera.readLine());
                            System.out.print("Inserisci il codice della opera: ");
                            codiceOpera = Integer.parseInt(tastiera.readLine());
                            s.eliminaOpera(codiceSala, codiceOpera);
                        } catch (Exception e)
                        {
                            System.out.println("Errore.\n");
                            System.exit(-1);
                        }
                        break;
                    case 2:
                        System.out.print("Inserisci il nome di un autore: ");
                        nomeAutore = tastiera.readLine();
                        valoreTotaleOpere = s.valoreTotaleOpere(nomeAutore);
                        System.out.println("Il valore totale delle opere di " + nomeAutore + "e' di " + valoreTotaleOpere + "\n");
                        break;
                    case 3:
                        s.creaReport();
                        break;
                    case 4:
                        s.stampaTutto();
                        break;
                    case 5:
                        return;
                }
            }
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
            System.exit(-2);
        }
    }

}
