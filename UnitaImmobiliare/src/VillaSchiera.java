/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Venerando
 */
public class VillaSchiera extends UnitaImmobiliare 
{
   private int nLivelli;
   private float mqGiardino;
   
   public String toString()
   {
      return (super.toString() + ", " + nLivelli + ", " + mqGiardino);
   }
}
