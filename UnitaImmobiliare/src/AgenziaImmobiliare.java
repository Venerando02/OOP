/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Venerando
 */

import java.io.*;

public class AgenziaImmobiliare 
{
    public static int menu(BufferedReader bf)
    {
      try{  
      System.out.print("\n******MENU*******\n\n");  
      System.out.print("1. Inserisci un nuovo Immobile.\n");
      System.out.print("2. Stampa proprieta' persona.\n");
      System.out.print("3. Stampa totale immobili.\n");
      System.out.print("4. Stampa giro di affari.\n");
      System.out.print("5. Rimozione immobile.\n");
      System.out.print("5. Exit.\n");
      System.out.print("------------> ");
      return Integer.parseInt(bf.readLine());
      }
      catch(IOException e)
      {
        System.out.println("Scelta non valida.");
      }
      return -1;
    }
    
    public static int inserimentoImmobile(BufferedReader bf, UnitaImmobiliare elenco[], int numeroImmobili) throws UnitaPresenteException
    {
       String identificativo;
       for(int i = 0; i < numeroImmobili; i++)
       {
         if(elenco[i].getId().equals(identificativo))
         {
            throw new UnitaPresenteException();
         }
       }
       int scelta = -1; 
       System.out.print("Inserire: 0) appartamento, 1) villa a schiera, 2) villa singola... ");
       scelta = Integer.parseInt(bf.readLine());
       if(scelta == 0)
       {
         elenco[numeroImmobili++] = new Appartamento();
       }
       else if(scelta == 1)
       {
         elenco[numeroImmobili++] = new VillaSchiera();
       }
       else
       {
           elenco[numeroImmobili++] = new VillaSingola();
       }
       return numeroImmobili;
    }
    
    public static void stampaProprieta(UnitaImmobiliare elenco[], int numeroUnita, String cf)
    {
      for(int i = 0; i < numeroUnita; i++)
      {
         if(elenco[i].getcf().equals(cf))
         {
             System.out.println(elenco[i]);
         }
      }
    }
    
    public static void StampaImmobiliVendita(UnitaImmobiliare elenco[], int numeroUnita)
    {
      for(int i = 0; i < numeroUnita; i++)
      {
        if(elenco[i].getVendita())
        {
          System.out.println(elenco[i]);
        }
      }
    }
    
    public static void giroaffari(UnitaImmobiliare elenco[], int numeroUnita)
    {
      float tot = 0.0F;
      for(int i = 0; i<numeroUnita; i++)
      {
        tot+=elenco[i].getPrezzo();
      }
      System.out.print("Totale immobili in vendita: " + tot);
    }
    
    public static int rimozioneImmobile(UnitaImmobiliare elenco[], int numeroUnita, String id)
    {
      for(int i = 0; i < numeroUnita; i++)
      {
        if(elenco[i].getId().equals(id))
        {
          elenco[i] = elenco[numeroUnita - 1];
          elenco[numeroUnita] = null;
          numeroUnita--;
          return numeroUnita;
        }
      }
      System.out.print("ID non trovato");
      return -1;
    }
    
    public static void main(String args[])
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        UnitaImmobiliare elenco[] = null;
        int numUnita = 0;
        int N, scelta = 0;
        String id;
        try
        {
            System.out.print("Inserire il numero di unita' da inserire: ");
            N = Integer.parseInt(bf.readLine());
            elenco = new UnitaImmobiliare[N];
            
            while(scelta != 6)
            {
               switch(menu(bf))
               {
                   case 1:
                       numUnita = inserimentoImmobile(bf, elenco, numUnita);
                       break;
                   case 2:
                       String cf;
                       System.out.print("Inserire il cf: ");
                       cf = bf.readLine();
                       stampaProprieta(elenco, numUnita, cf);
                       break;
                   case 3:
                       StampaImmobiliVendita(elenco, numUnita);
                       break;
                   case 4:
                       giroaffari(elenco, numUnita);
                       break;
                   case 5:
                       System.out.print("Inserisci l'identificativo: ");
                       id = bf.readLine();
                       numUnita = rimozioneImmobile(elenco, numUnita, id);
                       break;
                   case 6:
                       System.exit(0);
                   default:
                       System.out.print("Scelta non valida.\n");
               }
            }
        }
        catch(Exception e)
        {
            System.exit(-1);
        }
    }
}
