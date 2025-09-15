/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Venerando
 */
public abstract class UnitaImmobiliare 
{
   private String id;
   private String descrizione;
   private String indirizzo;
   private String cf;
   private float mq;
   private int nVani;
   private float prezzo;
   private boolean vendita;
   
   
   public String getId()
   {
      return id;
   }
   
   public String getcf()
   {
     return cf;
   }
   
   public String toString()
   {
     return (id + ", " + descrizione + ", " + indirizzo + ", " + prezzo);
   }
   
   public boolean getVendita()
   {
     return vendita;
   }
   
   public float getPrezzo()
   {
     return prezzo;
   }
}
