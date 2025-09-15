/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesquadra;

/**
 *
 * @author Venerando
 */
public class Squadra
{
  private String nome;
  private String sede;
  private Giocatore elenco[], elencoCostosi[];
  private int nGiocatori;
  private int numGiocatoriCostosi;
  
  public Squadra(String nome, String sede, int N)
  {
    this.nome = nome;
    this.sede = sede;
    elenco = new Giocatore[N];
    nGiocatori = 0;
    numGiocatoriCostosi = 0;
  }
  
  public void addGiocatore(Giocatore g)
  {
      if(nGiocatori == elenco.length)
      {
          System.out.print("Squadra piena.\n");
          return;
      }
      elenco[nGiocatori++] = g;
  }
  
  public void eliminaGiocatore(String cartellino) throws GiocatorenonTrovato
  {
    for(int i = 0; i<nGiocatori; i++)
    {
      if(elenco[i].getCartellino().equals(cartellino))
      {
        elenco[i] = elenco[nGiocatori - 1];
        elenco[nGiocatori - 1] = null;
        nGiocatori--;
      }
    }
    throw new GiocatorenonTrovato();
  }
  
  public void spostaGiocatori(float soglia)
  {
    for(int i = 0; i<nGiocatori; i++)
    {
        if(elenco[i].getValore() > soglia)
        {
            elencoCostosi[]
        }
    }
  }
}
