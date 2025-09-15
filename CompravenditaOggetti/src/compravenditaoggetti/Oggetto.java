/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compravenditaoggetti;

/**
 *
 * @author Venerando
 */
public class Oggetto 
{
  private String id;
  private String descrizione;
  private float prezzo;
  private boolean venduto;
  
  public Oggetto(String id, String descrizione, float prezzo, boolean venduto)
  {
    this.id = id;
    this.descrizione = descrizione;
    this.prezzo = prezzo;
    this.venduto = venduto;
  }
  
  public String toString()
  {
      String testo = "Oggetto: ";
      
      testo += id + " " + descrizione + " " + prezzo + " " + venduto + "\n";
      return testo;
  }
  
  public float getPrezzo()
  {
    return prezzo;
  }
  
  public String getIdentificativo()
  {
    return id;
  }
  
  public boolean equals(Object o)
  {
    return id.equals(((Oggetto)o).getIdentificativo());
  }
  
}
