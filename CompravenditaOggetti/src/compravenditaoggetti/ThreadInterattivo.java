/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compravenditaoggetti;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class ThreadInterattivo extends Thread 
{
    
  private GestioneCategorie gc;
  
  public ThreadInterattivo(GestioneCategorie gc)
  {
    this.gc = gc;
  }
  
  public static int menu(BufferedReader bf)
  {
      int scelta = 0;
      try
      {
          System.out.println("********MENU*******");
          System.out.println("1. Prezzo medio oggetti.");
          System.out.println("2. Elimina oggetto.");
          System.out.println("3. Stampa report.");
          System.out.println("4. Stampa tutto.");
          System.out.println("5. Uscita.");
          System.out.print("-----> ");
          scelta = Integer.parseInt(bf.readLine());
      }
      catch(IOException e)
      {
          System.out.print("Errore di I/O.\n");
          System.exit(-2);
      }
      return scelta;
  }
  
  public void run()
  {
    try
    {
        int scelta = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String fnameCategorie;
        String fnameOggetti;
        
        System.out.print("Inserisci il nome del file di Categorie: ");
        fnameCategorie = bf.readLine();
        
        System.out.print("Inserisci il nome del file di Oggetti: ");
        fnameOggetti = bf.readLine();
        
        gc.caricaCategorie(fnameCategorie);
        gc.caricaOggetti(fnameOggetti);
        
        while(scelta != 5)
        {
          scelta = menu(bf);
          switch(scelta)
          {
              case 1:
                  System.out.printf("Inserire il nome della categoria: ");
                  gc.prezzoMedio(bf.readLine());
                  break;
              case 2:
                  System.out.print("Inserisci l'identificativo di un oggetto: ");
                  gc.eliminaOggetto(bf.readLine());
                  break;
              case 3:
                  gc.stampaReport();
                  break;
              case 4:
                  gc.stampa();
                  break;
          }  
        }
    }
    catch(Exception e)
    {
        System.out.println("Errore di I/O.");
        System.exit(-1);
    }
  }    
}
