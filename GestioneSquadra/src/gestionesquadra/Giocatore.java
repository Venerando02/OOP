/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesquadra;

/**
 *
 * @author Venerando
 */
public class Giocatore 
{
  private String cartellino;
  private String nome;
  private int ruolo;
  private float valore;
  
  public Giocatore(String cartellino, String nome, int ruolo, float valore)
  {
    this.cartellino = cartellino;
    this.nome = nome;
    this.ruolo = ruolo;
    this.valore = valore;
  }
  
  public String getCartellino()
  {
    return cartellino;
  }
  
  public float getValore()
  {
    return valore;
  }
}
