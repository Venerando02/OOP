/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compravenditaoggetti;

import java.util.*;
import java.io.*;

/**
 *
 * @author Venerando
 */
public class GestioneCategorie 
{
  private List <Categoria> listaCategorie;
  private String categoriaMaggioreNumeroOggetti;
  private String categoriaMaggioreValoreOggetti;
  
  public GestioneCategorie()
  {
    listaCategorie = new LinkedList <Categoria>();
  }
  
  public synchronized void caricaCategorie(String fileName)
  {
    try
    {  
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String nome;
        String descrizione;
        
        nome = bf.readLine();
        while(nome != null)
        {
          descrizione = bf.readLine();
          listaCategorie.add(new Categoria(nome, descrizione));
          nome = bf.readLine();
        }
        bf.close();
    }
    catch(IOException e)
    {
        System.out.println("Errore di I/O.\n");
        System.exit(-1);
    }
  }
  
  public synchronized void caricaOggetti(String fileName)
  {
    try
    {  
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String nome;
        String descrizione;
        float prezzo;
        boolean venduto;
        String categoria;
        
        nome = bf.readLine();
        while(nome != null)
        {
          descrizione = bf.readLine();
          prezzo = Float.parseFloat(bf.readLine());
          venduto = Boolean.parseBoolean(bf.readLine());
          categoria = bf.readLine();
          if(venduto == false)
          {
              for(Categoria c : listaCategorie)
              {
                if(categoria.equals(c.getNome()))
                {
                  c.addOggetto(new Oggetto(nome, descrizione, prezzo, venduto));
                }
            }  
          }
          nome = bf.readLine();
        }
        bf.close();
    }
    catch(IOException e)
    {
        System.out.println("Errore di I/O.\n");
        System.exit(-1);
    }
  }
  
  public synchronized void stampa()
  {
    for(Categoria c : listaCategorie)
    {
      System.out.println(c);
    }
  }
  
  public synchronized void prezzoMedio(String nome)
  {
      for(Categoria c : listaCategorie)
      {
        if(c.getNome().equals(nome))
        {
           System.out.println("Il prezzo medio e':" + c.prezzoMedio());
           break;
        }
      }
  }
  
  public synchronized void eliminaOggetto(String id)
  {
     for(Categoria c : listaCategorie)
     {
       c.eliminaOggetto(id);
     }
  }
  
  public synchronized void creaReport()
  {
     int max = -1;
     float maxValore = -1.0F, vtmp;
     categoriaMaggioreNumeroOggetti = "";
     
     for(Categoria c : listaCategorie)
     {
       if(c.numOggetti() > max)
       {
         max = c.numOggetti();
         categoriaMaggioreNumeroOggetti = c.getNome();
       }
       vtmp = c.valCategoria();
       if(vtmp > maxValore)
       {
           maxValore = vtmp;
           categoriaMaggioreValoreOggetti = c.getNome();
       }
     } 
  }
  
  public synchronized void stampaReport()
  {
    System.out.println("La categoria con piu' oggetti in vendita e': " + categoriaMaggioreNumeroOggetti);
    System.out.println("La categoria con maggiore valore e': " + categoriaMaggioreValoreOggetti);
  }
  
}
