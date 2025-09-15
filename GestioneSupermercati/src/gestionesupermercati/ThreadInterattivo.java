/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesupermercati;
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
   
   public ThreadInterattivo(Clienti c)
   {
       this.c = c;
   }
   
   public int menu()
   {
       int scelta = 0;
       try
       {
           System.out.println("******MENU******");
           System.out.println("1. Elimina acquisti.");
           System.out.println("2. Stampa clienti a cui nella data D bisogna consegnare merce.");
           System.out.println("3. Crea report.");
           System.out.println("4. Stampa tutto.");
           System.out.println("5. Esci.");
           System.out.print("--------> ");
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
           String nomeFileAcquisti;
           String data;
           int cont;
           float importo;
           
           System.out.print("Inserisci il nome del file clienti: ");
           nomeFileClienti = tastiera.readLine();
           System.out.print("Inserisci il nome del file relativo agli acquisti: ");
           nomeFileAcquisti = tastiera.readLine();
           System.out.print("Inserisci una data al fine di considerare gli acquisti successivi ad essa: ");
           data = tastiera.readLine();
           
           c.caricaClienti(nomeFileClienti);
           c.caricaAcquisti(nomeFileAcquisti, data);
           
           while(scelta != 6)
           {
               scelta = menu();
               switch(scelta)
               {
                   case 1:
                       System.out.print("Inserisci un importo: ");
                       importo = Float.parseFloat(tastiera.readLine());
                       cont = c.eliminaAcquistiClienti(importo);
                       System.out.println("Sono stati eliminati " + cont + " clienti.");
                       break;
                   case 2:
                       System.out.print("Inserisci un importo: ");
                       importo = Float.parseFloat(tastiera.readLine());
                       System.out.print("Inserisci una data: ");
                       data = tastiera.readLine();
                       c.stampaClientiMerceNonConsegnata(data, importo);
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
