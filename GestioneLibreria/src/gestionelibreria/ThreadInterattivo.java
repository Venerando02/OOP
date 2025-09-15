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
public class ThreadInterattivo extends Thread 
{
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    Scaffali s;

    public ThreadInterattivo(Scaffali s) 
    {
        this.s = s;
    }
    
    public int menu()
    {
        int scelta = 0;
        try
        {
            System.out.println("***** MENU *****");
            System.out.println("1. Stampa libri autore.");
            System.out.println("2. Elimina archivio libri dato un prezzo.");
            System.out.println("3. Crea report.");
            System.out.println("4. Stampa tutto.");
            System.out.println("5. Esci dal programma. ");
            System.out.print("--------> ");
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
            String fileLibri;
            String fileScaffali;
            String autore;
            String data;
            float prezzo;
            
            System.out.print("Inserisci il nome del file scaffali: ");
            fileScaffali = tastiera.readLine();
            System.out.print("Inserisci il nome del file libri: ");
            fileLibri = tastiera.readLine();
            
            s.caricaScaffali(fileScaffali);
            s.caricaLibri(fileLibri);
            
            while(scelta != 6)
            {
                scelta = menu();
                switch(scelta)
                {
                    case 1:
                        System.out.print("Inserisci il nome dell'autore: ");
                        autore = tastiera.readLine();
                        System.out.print("Inserisci la data: ");
                        data = tastiera.readLine();
                        s.stampaLibriAutore(autore, data);
                        break;
                    case 2:
                        System.out.print("Inserisci un prezzo: ");
                        prezzo = Float.parseFloat(tastiera.readLine());
                        s.eliminaLibro(prezzo);
                        break;
                    case 3:
                        s.stampaReport();
                        break;
                    case 4:
                        s.stampaTutto();
                        break;
                    case 5:
                        return;
                }
            }
        } 
        catch (Exception e)
        {
            System.out.println("Errore di I/O.");
            System.exit(-1);
        }
    }
}
