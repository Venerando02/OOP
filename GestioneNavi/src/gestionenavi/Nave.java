/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionenavi;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class Nave 
{
   private String nome;
   private int stazzaTonnellate;
   private int capienzaMax;
   private String portoPartenza;
   private String portoArrivo;
   private List<Prenotazione> listaPrenotazioni;
   
   public Nave(String nome, int stazzaTonnellate, int capienzaMax, String portoPartenza, String portoArrivo)
   {
       this.nome = nome;
       this.stazzaTonnellate = stazzaTonnellate;
       this.capienzaMax = capienzaMax;
       this.portoPartenza = portoPartenza;
       this.portoArrivo = portoArrivo;
       listaPrenotazioni = new LinkedList<Prenotazione>();
   }
   
   public String getNomeNave()
   {
       return nome;
   }
   
   public boolean postiDispobili()
   {
       if((capienzaMax - listaPrenotazioni.size()) > 0)
           return true;
       else
           return false;
   }
   
   public int getNumeroPrenotazioni()
   {
       return listaPrenotazioni.size();
   }
   
   public float getRicavoTotale()
   {
       float ricavoTot = 0.0F;
       for(Prenotazione p: listaPrenotazioni)
       {
           ricavoTot += p.getCostoViaggio();
       }
       return ricavoTot;
   }
   
   public void aggiungiPrenotazione(Prenotazione p)
   {
       listaPrenotazioni.add(p);
   }
   
   public String toString()
   {
       String stringa = "NAVE [" + nome + ", " + stazzaTonnellate + ", " + capienzaMax + ", " + portoPartenza + ", " + portoArrivo + "]\n\n";
       for(Prenotazione p: listaPrenotazioni)
       {
           stringa += p.toString();
       }
       return stringa;
   }
   
   public void stampaNaveTrattaDisponibile(String portoPartenza, String portoArrivo)
   {
       if(this.portoPartenza.equals(portoPartenza) && this.portoArrivo.equals(portoArrivo) && postiDispobili())
       {
           System.out.println(nome);
       }
   }
   
   public float calcolaImportoTotale(String nomePasseggero, String data)
   {
       float importoTot = 0.0F;
       String dato;
       try 
       { 
           PrintWriter fp = new PrintWriter(new FileWriter("output.txt"));
           for(Prenotazione p: listaPrenotazioni)
           {
               if((p.getNome().equals(nomePasseggero)) && (p.getDataViaggio().compareTo(data) > 0))
               {
                   dato = this.nome + "\n";
                   fp.write(dato);
                   importoTot += p.getCostoViaggio();
               }
           }
           fp.close();
       }
       catch (FileNotFoundException e) 
       {
           System.out.println("Errore sul file.\n");
           System.exit(-1);
       }
       catch (IOException e) 
       {
           System.out.println("Errore di I/O.\n");
           System.exit(-1);
       }
       return importoTot;
   } 
   
   public int eliminaPrenotazioni(String nomePasseggero, String nomeNave)
   {
       int cont = 0;
      
       if (this.nome.equals(nomeNave)) 
       {
           for (Iterator<Prenotazione> it = listaPrenotazioni.iterator(); it.hasNext();)
           {
               Prenotazione p = it.next();
               if (p.getNome().equals(nomePasseggero)) 
               {
                   it.remove();
                   cont++;
               }
           }
       }
       return cont;
   }
}
