/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionesquadra;

import java.io.*;

/**
 *
 * @author Venerando
 */
public class GestioneSquadra 
{
    
    public static int menu(BufferedReader bf)
    {
        int scelta = 0;
        try
        {
           System.out.print("\n****** MENU ******\n");
           System.out.print("1. Creazione della squadra. \n");
           System.out.print("2. Inserimento di un giocatore nella squadra. \n");
           System.out.print("3. Eliminazione di un giocatore. \n");
           System.out.print("4. Spostamento dei giocatori. \n");
           System.out.print("5. Calcolo del valore complessivo della squadra. \n");
           System.out.print("6. Exit. \n");
           System.out.print("---------> ");
           scelta = Integer.parseInt(bf.readLine());
        }
        catch(IOException e)
        {
           System.out.print("Scelta non valida.\n");
        }
        return scelta;
    }
    
    public static Squadra creazioneSquadra(BufferedReader bf)
    {
        String nome;
        String sede;
        int N;
        try
        {
          System.out.print("Inserire nome squadra: ");
          nome = bf.readLine();
          System.out.print("Inserire la sede: ");
          sede = bf.readLine();
          System.out.print("Inserire il numero N di giocatori: ");
          N = Integer.parseInt(bf.readLine());
        }
        catch(IOException e)
        {
          System.out.println("Errore.");
        }
        return (new Squadra(nome, sede, N));
    }
    
    public static void inserimentoGiocatore(Squadra s, BufferedReader bf)
    {
      String nome, cartellino;
      int ruolo;
      float valore;
      try
      {
         System.out.print("Nome: ");
         nome = bf.readLine();
         System.out.print("cartellino: ");
         cartellino = bf.readLine();
         System.out.print("ruolo: ");
         ruolo = Integer.parseInt(bf.readLine());
         System.out.print("valore: ");
         valore = Float.parseFloat(bf.readLine());
         s.addGiocatore(new Giocatore(cartellino, nome, ruolo, valore));
      }
      catch(IOException e)
      {
          System.out.print("Errore.\n");
      }
    }
    
    public static void eliminaGiocatore(Squadra s, BufferedReader bf)
    {
        String cartellino;
        try
        {
           System.out.print("Inserire il cartellino del giocatore: ");
           cartellino = bf.readLine();
           s.eliminaGiocatore(cartellino);
        }
        catch(Exception e){}
    }
    
    public static void main(String[] args) 
    {
        
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int scelta = 0;
            Squadra s = null;
            while(scelta != 6)
            {
               scelta = menu(bf);
               switch(scelta)
               {
                   case 1:
                       if(s == null)
                           s = creazioneSquadra(bf);
                       else 
                           System.out.print("Squadra gia' presente.\n");
                       break;
                   case 2:
                       inserimentoGiocatore(s, bf);
                       break;
                   case 3:
                       eliminaGiocatore(s, bf);
                       break;
                   case 4:
                       System.out.print("");
                       break;
                   case 5:
                       break;
                   case 6:
                       System.exit(0);
                       break;
               }
            }
        }
        catch(Exception e)
        {
           System.out.print("Scelta non valida.\n");
        }
    }    
}
