/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionepalestra;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Disciplina 
{
   private String nome;
   private String responsabile;
   private int capienzaMax;
   private float tariffa;
   private List<Iscritto> listaIscritti;
   
   public Disciplina(String nome, String responsabile, int capienzaMax, float tariffa)
   {
       this.nome = nome;
       this.responsabile = responsabile;
       this.capienzaMax = capienzaMax;
       this.tariffa = tariffa;
       listaIscritti = new LinkedList<Iscritto>();
   }
   
   public int getCapienzaMax()
   {
       return capienzaMax;
   }
   
   public String getNome()
   {
       return nome;
   }
   
   public String toString()
   {
       String stringa = "DISCIPLINA [" + nome + ", " + responsabile + ", " + capienzaMax + ", " + tariffa + "] \n";
       for(Iscritto i : listaIscritti)
       {
           stringa += i.toString();
       }
       return stringa;
   }
   
   public void inserisciIscritto(Iscritto i)
   {
       listaIscritti.add(i);
   }
   
   public float getTariffa()
   {
       return tariffa;
   }
   
   public boolean eliminaIscritto(String cf)
   {
       return (listaIscritti.remove(new Iscritto("", cf, "")));
   }
   
   public boolean isFull()
   {
       return (capienzaMax == listaIscritti.size());
   }
   
   public float calcoloRicavo()
   {
       int numIscritti = listaIscritti.size();
       float ricavo = tariffa * numIscritti;
       return numIscritti;
   }
}
