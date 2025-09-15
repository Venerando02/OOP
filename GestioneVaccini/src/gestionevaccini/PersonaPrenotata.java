/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevaccini;

public class PersonaPrenotata 
{
   private String nome;
   private String cf;
   private int eta;
   
   public PersonaPrenotata(String nome, String cf, int eta)
   {
       this.nome = nome;
       this.cf = cf;
       this.eta = eta;
   }
   
   public int getEta()
   {
       return eta;
   }
   
   public String toString()
   {
       return "[" + cf + ", " + nome + ", " + eta + "] \n";
   }
}
