/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compravenditaoggetti;

import java.util.*;
/**
 *
 * @author Venerando
 */
public class Categoria 
{
  private String nome;
  private String descrizione;
  private List <Oggetto> listaOggetti;
  
  public Categoria(String nome, String descrizione)
  {
    this.nome = nome;
    this.descrizione = descrizione;
    listaOggetti = new LinkedList <Oggetto>();
  }
  
  public String getNome()
  {
    return nome;
  }
  
  public void addOggetto(Oggetto o)
  {
      listaOggetti.add(o);
  }
  
  public String toString()
  {
      String testo = "nome: ";
      testo += nome + "descrizione: " + descrizione + "\n";
     for(Oggetto o : listaOggetti)
     {
        testo += "\t" + o; 
     }
     return testo;
  }
  
  public float prezzoMedio()
  {
    float somma = 0.0F;
    if(listaOggetti.isEmpty())
        return 0;
    for(Oggetto o : listaOggetti)
    {
        somma += o.getPrezzo();
    } 
    return somma/listaOggetti.size();
  }
  
  public void eliminaOggetto(String id)
  {
    // funziona ma non va utilizzato
    // for(Oggetto o: listaOggetti){
    // if(o.getidef()equals(id))
    // listaOggetti.remove();
    listaOggetti.remove(new Oggetto(id, "", 0, true));
  }
  
  public int numOggetti()
  {
    return listaOggetti.size();
  }
  
  public float valCategoria()
  {
    float somma = 0.0F;
    for(Oggetto o: listaOggetti)
        somma += o.getPrezzo();
    return somma;
  }
}
