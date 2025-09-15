/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Venerando
 */
public class Appartamento extends UnitaImmobiliare 
{
      private int piano;
      private int numPosto;
      
      public String toString()
      {
        return (super.toString() + ", " + piano + ", " + numPosto);
      }
}
