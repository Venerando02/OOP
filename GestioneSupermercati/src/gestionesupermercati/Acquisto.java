/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesupermercati;

/**
 *
 * @author Venerando
 */
public class Acquisto
{
   private String descrizioneAcquisto;
   private String idScontrinoFiscale;
   private float importo;
   private String dataAcquisto;
   private boolean merceConsegnata;
   
   public Acquisto(String descrizioneAcquisto, String idScontrinoFiscale, float importo, String dataAcquisto, boolean merceConsegnata)
   {
       this.descrizioneAcquisto = descrizioneAcquisto;
       this.idScontrinoFiscale = idScontrinoFiscale;
       this.importo = importo;
       this.dataAcquisto = dataAcquisto;
       this.merceConsegnata = merceConsegnata;
   }
   
   public String toString()
   {
       return "[" + idScontrinoFiscale + ", " + descrizioneAcquisto + ", " + importo + ", " + dataAcquisto + ", " + merceConsegnata + "] \n";
   }
   
   public boolean getMerceConsegnata()
   {
       return merceConsegnata;
   }
   
   public String getData()
   {
       return dataAcquisto;
   }
   
   public float getImporto()
   {
       return importo;
   }
           
}
