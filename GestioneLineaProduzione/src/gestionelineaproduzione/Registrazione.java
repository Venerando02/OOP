/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelineaproduzione;

/**
 *
 * @author Venerando
 */
public class Registrazione 
{
    private String id;
    private String data;
    private int quantitaProdotte;
    private int numPezziDifettosi;
    
    public Registrazione(String id, String data, int quantita, int numPezzi)
    {
        this.id = id;
        this.data = data;
        this.quantitaProdotte = quantita;
        this.numPezziDifettosi = numPezzi;
    }
    
    public String toString()
    {
        return "[" + data + "; " + quantitaProdotte + "; " + numPezziDifettosi + "] \n";
    }
    
    public int getQuantitaProdotte()
    {
        return quantitaProdotte;
    }
    
    public String getData()
    {
        return data;
    }
    
    public int getPezziDifettosi()
    {
        return numPezziDifettosi;
    }
    
    public boolean equals(Object o)
    {
        return (data.equals(((Registrazione) o).data));
    }
}
