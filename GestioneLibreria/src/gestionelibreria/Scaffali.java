/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelibreria;

import java.util.*;
import java.io.*;

/**
 *
 * @author Venerando
 */
public class Scaffali {

    private List<Scaffale> listaScaffali;
    private String ScaffalePrezzoMedioPiuAlto;

    public Scaffali() {
        listaScaffali = new LinkedList<Scaffale>();
    }

    public void stampaTutto() {
        for (Scaffale s : listaScaffali) {
            System.out.println(s.toString());
        }
    }

    public synchronized void caricaScaffali(String nomeFile) {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String tema;
            String descrizione;
            float scontoPercentuale;

            tema = fp.readLine();
            while (tema != null) {
                descrizione = fp.readLine();
                scontoPercentuale = Float.parseFloat(fp.readLine());

                listaScaffali.add(new Scaffale(tema, descrizione, scontoPercentuale));

                tema = fp.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
            System.exit(-2);
        }
    }

    public synchronized void stampaLibriAutore(String autore, String data) throws LibriNonEliminatiException {
        for (Scaffale s : listaScaffali) {
            s.stampaLibri(autore, data);
        }
    }

    public synchronized void eliminaLibro(float prezzo) throws LibriNonEliminatiException {
        int libriEliminati = 0;

        for (Scaffale s : listaScaffali) {
            if (s.EliminaLibro(prezzo)) {
                libriEliminati++;
            }
        }

        if (libriEliminati == 0) {
            throw new LibriNonEliminatiException();
        }
    }

    public synchronized void creaReport()
    {
        ScaffalePrezzoMedioPiuAlto = "";
        float max = 0.0F, tmp;
        for(Scaffale s : listaScaffali)
        {
            tmp = s.prezzoMedioTotaleLibriScontati();
            if(tmp > max)
            {
                max = tmp;
                ScaffalePrezzoMedioPiuAlto = s.getTema();
            }
        }
    }
    
    public synchronized void stampaReport()
    {
        System.out.println("Lo scaffale con il prezzo medio scontato piu' alto e': " + ScaffalePrezzoMedioPiuAlto);
    }
    
    public synchronized void caricaLibri(String nomeFile) {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));

            String codice; // CHIAVE
            String tema;
            String autore;
            String titolo;
            float prezzo;
            String dataPubblicazione;
            boolean disponibile;

            codice = fp.readLine();

            while (codice != null) {
                tema = fp.readLine();
                autore = fp.readLine();
                titolo = fp.readLine();
                prezzo = Float.parseFloat(fp.readLine());
                dataPubblicazione = fp.readLine();
                disponibile = Boolean.parseBoolean(fp.readLine());

                for (Scaffale s : listaScaffali) {
                    if ((s.getTema().equals(tema)) && (disponibile == true)) {
                        s.AggiungiLibro(new Libro(codice, tema, autore, titolo, prezzo, dataPubblicazione, disponibile));
                    }
                }

                codice = fp.readLine();
            }
            fp.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
            System.exit(-2);
        }
    }

}
